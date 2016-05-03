/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.message;

import io.github.ketao1989.scheduler.KafkaConfig;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * 发送消息工具类
 * 
 * @author tao.ke Date: 16/1/1 Time: 下午10:59
 */
public class MsgProducerUtils {

    private static final Producer<String, String> producer;

    // 这里的broker 必须和 kafka broker server的配置一致,并且为hostname
    // 例如配置为 advertised.host.name=kafka.consumer.test
    static {
        Properties properties = new Properties();
        properties.put("metadata.broker.list", KafkaConfig.broker_list);
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
