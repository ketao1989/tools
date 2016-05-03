/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.kafka;

/**
 * @author tao.ke Date: 16/1/6 Time: 下午4:34
 */
public class NewKafkaProducer {

    private static final String TOPIC = "Blanka-topic-dev-t";

    public static void main(String[] args) throws Exception {

       new Thread(new JavaProducer()).start();
    }


}
