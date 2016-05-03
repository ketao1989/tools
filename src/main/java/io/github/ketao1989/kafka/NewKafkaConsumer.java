/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.kafka;

/**
 * @author tao.ke Date: 16/1/6 Time: 下午3:49
 */
public class NewKafkaConsumer {

    public static void main(String[] args) {
        new Thread(new JavaConsumer()).start();
    }
}
