/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tao.ke Date: 15/12/27 Time: 下午9:27
 */
public class TestKafkaConsumer implements Runnable {

    private static final String TOPIC = "Blanka-trade-dev";

    private static final String CONSUMER_GROUP = "test-kafka-consumer";

    private final ConsumerConnector consumerConnector;

    private final String topic;

    public TestKafkaConsumer(String zkAddress, String consumerGroup, String topic) {
        consumerConnector = kafka.consumer.Consumer
                .createJavaConsumerConnector(createConsumerConfig(zkAddress, consumerGroup));
        this.topic = topic;
    }

    public void shutdown() {
        if (consumerConnector != null)
            consumerConnector.shutdown();
    }

    public void run() {



        System.out.println(Thread.currentThread().getName());

        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector
                .createMessageStreams(topicCountMap);
        final KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);

        // now launch all the threads
        //
        // executor = Executors.newFixedThreadPool(a_numThreads);

        // now create an object to consume the messages
        //
        new TestConsumerRun().run(stream,consumerConnector);


    }

    private static ConsumerConfig createConsumerConfig(String zkAddress, String consumerGroup) {
        Properties props = new Properties();
        props.put("zookeeper.connect", zkAddress);
        props.put("group.id", consumerGroup);
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        // props.put("auto.commit.interval.ms", "1000");
         props.put("auto.offset.reset","smallest");
        props.put("auto.commit.enable", "false");
        props.put("consumer.id",Thread.currentThread().getName());
        // props.put("offsets.channel.backoff.ms","kafka");

        return new ConsumerConfig(props);
    }

    public static void main(String[] args) {

        // TestKafkaConsumer example = new TestKafkaConsumer("10.10.38.3:2181", CONSUMER_GROUP, TOPIC);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new TestKafkaConsumer("10.10.38.3:2181", CONSUMER_GROUP, TOPIC));

        // example.run(3);

        try {
            Thread.sleep(100000);
        } catch (InterruptedException ie) {

        } finally {
            executor.shutdown();
        }

    }

}
