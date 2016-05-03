/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.message;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * @author tao.ke Date: 16/1/1 Time: 下午11:29
 */
public class DefaultPartitioner implements Partitioner {

    public DefaultPartitioner(VerifiableProperties props) {
    }

    public int partition(Object key, int numPartitions) {

        return Integer.parseInt((String) key);

    }
}
