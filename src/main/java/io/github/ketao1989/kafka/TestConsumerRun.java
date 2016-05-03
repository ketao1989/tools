/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.kafka;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * @author tao.ke Date: 15/12/27 Time: 下午9:56
 */
public class TestConsumerRun  {


    public void run(KafkaStream<byte[], byte[]> stream,ConsumerConnector consumerConnector) {
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext() ){

            MessageAndMetadata<byte[], byte[]> msg = it.next();


            System.out.println("Thread " +Thread.currentThread().getName() + ": " + new String(msg.message()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //  System.out.println("-------------start-------------"+ new String(msg.message()));
                //consumerConnector.commitOffsets();
                System.out.println("-------------end-------------"+ new String(msg.message()));
            consumerConnector.commitOffsets();



        }

        System.out.println("Shutting down Thread: ");
    }


}
