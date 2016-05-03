/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.client;

import com.google.common.base.Joiner;
import io.github.ketao1989.scheduler.KafkaConfig;
import io.github.ketao1989.scheduler.KafkaZkUtils;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.List;
import java.util.Properties;

/**
 * @author tao.ke Date: 16/1/3 Time: 下午3:08
 */
public class ClientProducerUtils {

    private static final Producer<String, String> producer;

    private static final List<String> brokers = KafkaZkUtils.getBrokers(KafkaConfig.zkAddress);

    // 这里的broker 必须和 kafka broker server的配置一致,并且为hostname
    // 例如配置为 advertised.host.name=kafka.consumer.test
    static {
        Properties properties = new Properties();
        properties.put("metadata.broker.list", Joiner.on(',').join(brokers));
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("partitioner.class", "io.github.ketao1989.scheduler.message.DefaultPartitioner");
        properties.put("request.required.acks", "1");
        ProducerConfig config = new ProducerConfig(properties);
        producer = new Producer<String, String>(config);
    }

    /**
     * 具体的消息发送方法
     *
     * @param topic
     * @param partitionerNum
     * @param msg
     */
    public static void send(String topic, String partitionerNum, String msg) {

        KeyedMessage<String, String> message = new KeyedMessage<String, String>(topic, partitionerNum, msg);
        producer.send(message);

    }
}
