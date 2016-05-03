/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.client;

import io.github.ketao1989.jackson.JsonUtils;
import io.github.ketao1989.scheduler.KafkaConfig;
import io.github.ketao1989.scheduler.KafkaConstants;
import io.github.ketao1989.scheduler.message.MessageBody;
import io.github.ketao1989.scheduler.message.MsgDelayedLevel;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午5:34
 */
public class DelayedTaskSendService {

    // 如果环境支撑注入,则可以不要这部分
    public static final DelayedTaskSendService delayedTaskSendService = new DelayedTaskSendService();

    private DelayedTaskSendService() {

    }

    /**
     * 发送延迟执行的任务,taskProperty 表示需要执行的方法调用,对于异步延迟执行,返回值可以不需要考虑.
     * 
     * 具体重试规则,由业务来决定,是否需要重新提交延迟任务到队列中
     *
     * @param taskProperty
     * @param level
     * @return
     */
    public boolean sendDelayedTask(DelayedTaskProperty taskProperty, MsgDelayedLevel level) {

        String topic = KafkaConstants.DELAYED_MSG_PREFIX + level.getLevel();

        MessageBody body = convertBody(taskProperty, topic);

        String partitionerNum = RpcDefaultPartitioner.computePartitioner(0, topic, KafkaConfig.zkAddress);

        ClientProducerUtils.send(topic, partitionerNum, JsonUtils.encode(body));

        return true;

    }

    private MessageBody convertBody(DelayedTaskProperty taskProperty, String topic) {

        MessageBody body = new MessageBody();

        body.setCurrentTime(System.currentTimeMillis());

        body.setPartitionNum(
                RpcDefaultPartitioner.computePartitioner(taskProperty.getRouteKey(), topic, KafkaConfig.zkAddress));

        body.setTopic(KafkaConfig.project_topic);

        body.setRealPayLoad(JsonUtils.encode(taskProperty));

        return body;
    }
}
