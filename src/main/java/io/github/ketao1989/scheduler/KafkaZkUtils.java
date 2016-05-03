/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler;

import com.google.common.collect.Lists;
import io.github.ketao1989.jackson.JsonUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午3:47
 */
public class KafkaZkUtils {

    private static final Logger logger = LoggerFactory.getLogger(KafkaZkUtils.class);

    private static final String BrokerIdsPath = "/brokers/ids";
    private static final String BrokerTopicsPath = "/brokers/topics";
    private static final String TopicConfigPath = "/config/topics";
    private static final String DeleteTopicsPath = "/admin/delete_topics";

    public static String getTopicPath(String topic) {
        return BrokerTopicsPath + "/" + topic;
    }

    public static String getTopicPartitionsPath(String topic) {
        return getTopicPath(topic) + "/partitions";
    }

    /**
     * 获取topic 分区. 由于构造CuratorFramework 成功很大,所以请缓存结果,或者使用下面的方法来获取
     * 
     * @param zkAddress
     * @param topic
     * @return
     */
    public static List<String> getPartitionsForTopic(String zkAddress, String topic) {

        CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, 6000, 6000, new RetryForever(1000));

        try {
            client.start();

            return getPartitionsForTopic(client, topic);
        } finally {
            client.close();
        }
    }

    public static List<String> getBrokers(String zkAddress) {

        CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, 6000, 6000, new RetryForever(1000));

        try {
            client.start();

            return getBrokers(client);
        } finally {
            client.close();
        }
    }

    /**
     * 获取某个指定topic 的分区情况.
     * 
     * @param zkClient 已经start,并且close由其关闭
     * @param topic
     * @return
     */
    public static List<String> getPartitionsForTopic(CuratorFramework zkClient, String topic) {

        try {

            return zkClient.getChildren().forPath(getTopicPartitionsPath(topic));

        } catch (Exception e) {

            logger.error("getPartitionsForTopic error.topic:{}, e:", topic, e);
            return null;
        }

    }

    /**
     * 简单需求的时候,可以使用,对应broker,一般使用zk的watch保存监听比较好
     * 
     * @param zkClient
     * @return
     */
    public static List<String> getBrokers(CuratorFramework zkClient) {

        try {

            List<String> brokerIds = zkClient.getChildren().forPath(BrokerIdsPath);

            if (brokerIds == null || brokerIds.isEmpty()) {
                return null;
            }

            List<String> brokerHostInfo = Lists.newArrayList();
            for (String id : brokerIds) {

                String info = new String(zkClient.getData().forPath(BrokerIdsPath + "/" + id));

                Map<String, Object> data = JsonUtils.decode(info, Map.class);

                brokerHostInfo.add(data.get("host") + ":" + data.get("port"));
            }

            return brokerHostInfo;
        } catch (Exception e) {

            logger.error("getBrokers error. e:", e);
            return null;
        }

    }

}
