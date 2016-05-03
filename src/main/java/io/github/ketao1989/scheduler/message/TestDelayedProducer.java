/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.scheduler.message;

import io.github.ketao1989.jackson.JsonUtils;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author tao.ke Date: 16/1/2 Time: 上午1:21
 */
public class TestDelayedProducer {

    private static final String TOPIC = "blanka-trade-dev";

    public static void main(String[] args) {

        Properties properties = new Properties();

        // 这里的broker 必须和 kafka broker server的配置一致,并且为hostname
        // 例如配置为 advertised.host.name=kafka.consumer.test
        properties.put("metadata.broker.list", "10.10.38.3:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("partitioner.class", "io.github.ketao1989.kafka.TestKafkaPartitioner");
        properties.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(properties);

        Producer<String, String> producer = new Producer<String, String>(config);

        try {

            int count = 10;

            Map<String, String> map = new HashMap<String, String>();
            map.put("transactionId", "transfer_1451471093787");
            map.put("accountId", "1000010000002000046");
            map.put("fundTradeType", "1");
            map.put("fundTradeMode", "1");
            map.put("transactionDesc", "consumer");
            map.put("amount", "44");
            map.put("productId", "1");

            String msg = JsonUtils.encode(map);

            MessageBody body = new MessageBody();
            body.setCurrentTime(System.currentTimeMillis());
            body.setPartitionNum("1");
            body.setRealPayLoad(msg);
            body.setTopic(TOPIC);

            String key = String.valueOf(RandomUtils.nextInt(0, 100000));

            KeyedMessage<String, String> message = new KeyedMessage<String, String>("KAFKA_DELAYED_MSG_3", key, JsonUtils.encode(body));
            producer.send(message);

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
