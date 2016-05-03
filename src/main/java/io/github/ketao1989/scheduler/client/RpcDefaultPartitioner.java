/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.client;

import io.github.ketao1989.scheduler.PartitionerUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午7:26
 */
public class RpcDefaultPartitioner {

    public static String computePartitioner(int key, String topic, String zkAddress) {

        int total = PartitionerUtils.queryTopicPartitionerTotal(topic, zkAddress);

        if (key <= 0) {
            return String.valueOf(RandomUtils.nextInt(0, total));
        }

        return String.valueOf(key % total);

    }
}
