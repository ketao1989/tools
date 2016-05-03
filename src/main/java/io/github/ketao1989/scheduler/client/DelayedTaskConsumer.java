/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.client;

import io.github.ketao1989.jackson.JsonUtils;
import io.github.ketao1989.jackson.ParameterizedTypeReference;
import io.github.ketao1989.scheduler.KafkaConfig;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.commons.lang3.ClassUtils;
import org.aspectj.util.Reflection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午7:59
 */
public class DelayedTaskConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DelayedTaskConsumer.class);

    private static final String DEFAULT_GROUP_ID = "RPC.CONSUMER.GROUP";

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private static final ConcurrentHashMap<String, Class> CLASS_MAP = new ConcurrentHashMap<String, Class>();

    private static final Object LOCK = new Object();

    private ConsumerConnector connector ;

    public void shutdown(){

        if (executorService != null){
            executorService.shutdown();
        }

        if (connector != null){
            connector.shutdown();
        }
    }


    public void process() {

        connector = Consumer.createJavaConsumerConnector(buildConsumerConfig());

        executorService.submit(new Runnable() {
            public void run() {

                String topic = KafkaConfig.project_topic;

                logger.info("start consumer. topic:{}.", topic);

                Map<String, Integer> topicCountMap = new HashMap<String, Integer>();

                topicCountMap.put(topic, 1);

                Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = connector
                        .createMessageStreams(topicCountMap);

                final KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);

                ConsumerIterator<byte[], byte[]> it = stream.iterator();

                while (it.hasNext()) {

                    String msg = new String(it.next().message());

                    logger.info("topic:{},msg:{}", topic, msg);

                    try {
                        DelayedTaskProperty property = JsonUtils.decode(msg,
                                new ParameterizedTypeReference<DelayedTaskProperty>() {
                        });
                        processHandler(property, connector);
                    } catch (Exception e) {
                        logger.error("e:", e);
                    }
                }
            }
        });
    }

    /**
     * 处理的核心逻辑,反射方式调用方法
     * 
     * @param property
     * @param connector
     */
    private void processHandler(DelayedTaskProperty property, ConsumerConnector connector) {

        Class clazz = CLASS_MAP.get(property.getClassFullName());

        if (clazz == null) {
            synchronized (LOCK) {
                try {
                    clazz = ClassUtils.getClass(property.getClassFullName());
                } catch (ClassNotFoundException e) {
                    logger.error("class reflect error.class:{} not find.e:", property.getClassFullName(), e);
                    connector.commitOffsets();
                    return;
                }
                CLASS_MAP.putIfAbsent(property.getClassFullName(), clazz);
            }
        }

        // FIXME: 16/1/2 这里的异常等处理后续需要细化,确保有些额外异常不进行commit?
        try {

            Object target = clazz.newInstance();
            Reflection.invokeN(clazz, property.getMethodName(), target, property.getArgs());

        } catch (Exception e) {
            logger.error("e:", e);
        } finally {
            connector.commitOffsets();
        }

    }

    /**
     * 构造指定的消费者config
     * 
     * @return
     */
    private ConsumerConfig buildConsumerConfig() {
        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaConfig.zkAddress);
        props.put("group.id", DEFAULT_GROUP_ID);
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.offset.reset", "smallest");
        props.put("auto.commit.enable", "false");

        return new ConsumerConfig(props);
    }

}
