/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.message;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author tao.ke Date: 16/1/1 Time: 下午11:06
 */
public class MessageBody implements Serializable {

    private static final long serialVersionUID = -5328566422501836134L;

    /**
     * 当前时间戳
     */
    private long currentTime;

    /**
     * kafka 消息主题
     */
    private String topic;

    /**
     * 计算最终的分区
     */
    private String partitionNum;

    /**
     * 实际的消息体
     */
    private String realPayLoad;

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPartitionNum() {
        return partitionNum;
    }

    public void setPartitionNum(String partitionNum) {
        this.partitionNum = partitionNum;
    }

    public String getRealPayLoad() {
        return realPayLoad;
    }

    public void setRealPayLoad(String realPayLoad) {
        this.realPayLoad = realPayLoad;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
