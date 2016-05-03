/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.kafka;

import io.github.ketao1989.jackson.JsonUtils;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author tao.ke Date: 15/12/27 Time: 下午9:04
 */
public class TestKafkaProducer {

    private static final String TOPIC = "Blanka-topic-qa-fwl";

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.put("metadata.broker.list", "10.10.10.99:9092,10.10.10.99:9093,10.10.10.99:9094");
        // properties.put("metadata.broker.list", "10.10.38.3:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("partitioner.class", "io.github.ketao1989.kafka.TestKafkaPartitioner");
        properties.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(properties);

        Producer<String, String> producer = new Producer<String, String>(config);

        try {

            int count = 3;
            long start = System.currentTimeMillis();

            while (true) {

                if (count-- <= 0) {
                    System.out.println("time ----" + (System.currentTimeMillis() - start));
                    break;
                }

                Map<String, String> map = new HashMap<String, String>();

                map.put("transactionId", "BLANKA_r14519644039211451964385876");
                map.put("accountId", "1000010000002000046");
                map.put("fundTradeType", "1");
                map.put("fundTradeMode", "1");
                map.put("transactionDesc", "测试" + System.currentTimeMillis());
                map.put("amount", "44");
                map.put("productId", "1");

                String msg = JsonUtils.encode(map);

                String key = String.valueOf(RandomUtils.nextInt(0, 100000));

                KeyedMessage<String, String> message = new KeyedMessage<String, String>(TOPIC, key, msg);
                producer.send(message);
                System.out.println(message);
            }

            Thread.sleep(RandomUtils.nextInt(1, 10));

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            if (producer != null) {
                producer.close();
            }
        }
    }
}
