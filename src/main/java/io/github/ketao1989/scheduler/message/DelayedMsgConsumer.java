/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.message;

import io.github.ketao1989.jackson.JsonUtils;
import io.github.ketao1989.scheduler.KafkaConfig;
import io.github.ketao1989.scheduler.KafkaConstants;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 消费定时消息,核心处理逻辑
 *
 * 处理流程: 1. (producer处理)根据指定的延迟等级,指定不同的消息topic,发送消息; 2. 从kafka中获取需要延迟消费的消息,在消息实体中,解析需要有topic,计算好的分区结果,实际消息体; 3.
 * 根据延时等级,放置到不同的消费线程中,处理逻辑各个线程相同. 4. 构造实际的消息,发送到对应的分区中.
 *
 * (保证数据高可靠性)可以使用数据库将对应数据分发到对应的数据库分表中,比如:level + partitioner 分表
 *
 * @author tao.ke Date: 16/1/1 Time: 下午10:25
 */
public class DelayedMsgConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DelayedMsgConsumer.class);

    /**
     * 默认延迟的分组id
     */
    private static final String DELAYED_MSG_GROUP = "KAFKA_DELAYED_GROUP_ID";

    /**
     * 维护每个topic 的所有connector
     */
    private static final ConcurrentHashMap<String, ConsumerConnector> CONSUMER_CONNECTOR = new ConcurrentHashMap<String, ConsumerConnector>();

    /**
     * 维护每个topic 对应的延迟毫秒水平
     */
    private static final ConcurrentHashMap<String, Long> DELAYED_LEVEL_MS_TIMES = new ConcurrentHashMap<String, Long>();

    /**
     * 每个topic 分别一个线程进行处理
     */
    private static final ExecutorService executor = Executors.newFixedThreadPool(MsgDelayedLevel.values().length);

    private static final ConcurrentHashMap<String, ScheduledExecutorService> SCHEDULED_EXECUTOR_SERVICE_MAP = new ConcurrentHashMap<String, ScheduledExecutorService>();

    private static final ConcurrentHashMap<String, ArrayBlockingQueue<MessageBody>> CURRENT_TASK_MAP = new ConcurrentHashMap<String, ArrayBlockingQueue<MessageBody>>();

    static {

        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaConfig.zkAddress);
        props.put("group.id", DELAYED_MSG_GROUP);
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.offset.reset", "smallest");
        props.put("auto.commit.enable", "false");

        ConsumerConfig consumerConfig = new ConsumerConfig(props);

        /**
         * 每个topic 负责维护一个connector
         */
        for (MsgDelayedLevel delayedLevel : MsgDelayedLevel.values()) {
            CONSUMER_CONNECTOR.put(KafkaConstants.DELAYED_MSG_PREFIX + delayedLevel.getLevel(),
                    Consumer.createJavaConsumerConnector(consumerConfig));
            DELAYED_LEVEL_MS_TIMES.put(KafkaConstants.DELAYED_MSG_PREFIX + delayedLevel.getLevel(),
                    delayedLevel.getDelayedMs());
            SCHEDULED_EXECUTOR_SERVICE_MAP.put(KafkaConstants.DELAYED_MSG_PREFIX + delayedLevel.getLevel(),
                    Executors.newScheduledThreadPool(1));
            CURRENT_TASK_MAP.put(KafkaConstants.DELAYED_MSG_PREFIX + delayedLevel.getLevel(),
                    new ArrayBlockingQueue<MessageBody>(1));
        }
    }

    public void shutdown() {

        if (executor != null) {
            executor.shutdown();
        }

        for (Map.Entry<String, ScheduledExecutorService> executorEntry:SCHEDULED_EXECUTOR_SERVICE_MAP.entrySet()) {
            executorEntry.getValue().shutdown();
        }

        for (Map.Entry<String, ConsumerConnector> entry : CONSUMER_CONNECTOR.entrySet()) {
            entry.getValue().shutdown();
        }

    }

    /**
     * 具体的消费方法
     */
    public void process() {

        for (final Map.Entry<String, ConsumerConnector> delayedLevel : CONSUMER_CONNECTOR.entrySet()) {

            executor.submit(new Runnable() {

                public void run() {

                    logger.info("start consumer. topic:{}.", delayedLevel.getKey());

                    Map<String, Integer> topicCountMap = new HashMap<String, Integer>();

                    topicCountMap.put(delayedLevel.getKey(), 1);

                    Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = delayedLevel.getValue()
                            .createMessageStreams(topicCountMap);

                    final KafkaStream<byte[], byte[]> stream = consumerMap.get(delayedLevel.getKey()).get(0);

                    ConsumerIterator<byte[], byte[]> it = stream.iterator();

                    while (it.hasNext()) {

                        String msg = new String(it.next().message());

                        logger.info("topic:{},msg:{}", delayedLevel.getKey(), msg);

                        try {
                            MessageBody body = JsonUtils.decode(msg, MessageBody.class);
                            try {
                                CURRENT_TASK_MAP.get(delayedLevel.getKey()).put(body);
                            }catch (InterruptedException e){
                                // no process
                                e.printStackTrace();
                            }
                            processHandler(delayedLevel.getKey(), body, delayedLevel.getValue());
                        } catch (Exception e) {
                            logger.error("e:", e);
                        }
                    }

                }
            });
        }

    }

    /**
     * 由于每个队列消费,后面的执行时间肯定在前者之后, 所以依次处理即可,如果时间未到,则等待.
     *
     * @param key
     * @param body
     */
    private void processHandler(final String key, final MessageBody body, final ConsumerConnector connector) {

        long now = System.currentTimeMillis();

        if (body.getCurrentTime() > now || body.getCurrentTime() <= 0) {
            body.setCurrentTime(now);
        }
        long diff = now - body.getCurrentTime() - DELAYED_LEVEL_MS_TIMES.get(key);

        if (diff >= 0) {

            try {
                MsgProducerUtils.send(body.getTopic(), body.getPartitionNum(), body.getRealPayLoad());
            } catch (IllegalArgumentException e) {
                logger.error("producer params illegal. key:{},body:{},e:", key, body, e);
            }
            connector.commitOffsets();
            CURRENT_TASK_MAP.get(key).clear();
            logger.info("----------end 1-------------");
        } else {

            SCHEDULED_EXECUTOR_SERVICE_MAP.get(key).schedule(new Runnable() {
                public void run() {
                    processHandler(key, body, connector);
                }
            }, -diff, TimeUnit.MILLISECONDS);

        }

    }
}
