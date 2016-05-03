/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler;

import io.github.ketao1989.scheduler.client.DelayedTaskConsumer;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午7:40
 */
public class KafkaConfig {

    /**
     * consumer 和 producer 在一个zk集群中,在配置文件中配置
     */
    public static final String zkAddress = "10.10.38.3:2181";

    public static final String broker_list = "kafka.consumer.test:9092";

    public static final String project_topic = "ketao1989.github.io";

    /**
     * 初始化rpc相关配置和启动listener
     */
    public static void init() {

        final DelayedTaskConsumer consumer = new DelayedTaskConsumer();
        consumer.process();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("clean resources.......");
                consumer.shutdown();
            }
        }));
    }
}
