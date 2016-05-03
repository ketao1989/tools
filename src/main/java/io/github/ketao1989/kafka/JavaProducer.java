/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author tao.ke Date: 16/1/6 Time: 下午11:48
 */
public class JavaProducer implements Runnable {

    public void run() {

        Properties props = new Properties();
        props.put("bootstrap.servers", "10.10.38.3:9092");
        props.put("client.id", "DemoProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<Integer, String> producer = new KafkaProducer<Integer, String>(props);

        int messageNo = 1;
        while (messageNo<100) {
            String messageStr = "Message_" + messageNo;
            //long startTime = System.currentTimeMillis();
            // Send asynchronously
            producer.send(new ProducerRecord<Integer, String>("topic4", messageNo, messageStr));
            System.out.println(messageStr);
            ++messageNo;
        }

    }
}
