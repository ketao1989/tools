/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.I0Itec.zkclient.ZkClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryForever;
import org.jboss.netty.util.internal.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午2:46
 */
public class PartitionerUtils {

    private static final Logger logger = LoggerFactory.getLogger(PartitionerUtils.class);

    private static final ConcurrentHashMap<String, ZkClient> ZK_CLIENT_MAP = new ConcurrentHashMap<String, ZkClient>();

    private static Cache<String, Integer> TOPIC_PARTITIONER_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES).maximumSize(10240).build();

    public static int queryTopicPartitionerTotal(final String topic, final String zkAddress) {

        // localcache 保证只会有一个topic执行真正的加载动作
        try {

            return TOPIC_PARTITIONER_CACHE.get(topic, new Callable<Integer>() {
                public Integer call() throws Exception {

                    List<String> partList = KafkaZkUtils.getPartitionsForTopic(zkAddress,topic);

                    if (partList == null || partList.isEmpty()) {
                        throw new IllegalArgumentException(
                                String.format("not found kafka info for topic:%s in zkAddress:%s.", topic, zkAddress));
                    }

                    return partList.size();
                }
            });

        } catch (ExecutionException e) {
            logger.error("cache error. e:", e);
            return -1;
        }
    }

    public static void main(String[] args) {

        System.out.println(queryTopicPartitionerTotal("blanka-trade-dev","10.10.38.3:2181"));

        CuratorFramework client = CuratorFrameworkFactory.newClient("10.10.38.3:2181", 6000, 6000, new RetryForever(1000));

        try {
            client.start();
            System.out.println(KafkaZkUtils.getBrokers(client));
        } finally {
            client.close();
        }



    }
}
