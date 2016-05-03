/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.scheduler.message;

/**
 * @author tao.ke Date: 16/1/2 Time: 上午1:20
 */
public class TestDelayedExample {

    public static void main(String[] args) {

        final DelayedMsgConsumer consumer = new DelayedMsgConsumer();

        consumer.process();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("clean resources .......");
                consumer.shutdown();
            }
        }));
    }
}
