/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.client;

import io.github.ketao1989.scheduler.KafkaConfig;
import io.github.ketao1989.scheduler.message.MsgDelayedLevel;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午10:16
 */
public class TestDelayedTaskRpc {

    public static void main(String[] args) {

        KafkaConfig.init();

        DelayedTaskProperty delayedTaskProperty = new DelayedTaskProperty();
        delayedTaskProperty.setArgs(new Object[]{"ketao1989",27});
        delayedTaskProperty.setClassFullName(TestDelayedTaskRpc.class.getName());
        delayedTaskProperty.setMethodName("testEcho");
        delayedTaskProperty.setRouteKey(1);

        DelayedTaskSendService.delayedTaskSendService.sendDelayedTask(delayedTaskProperty, MsgDelayedLevel.TEN_S_DELAYED);

    }

    public void testEcho(String name, int age) {
        System.out.println("name is " + name + "------- age is " + age);
    }
}
