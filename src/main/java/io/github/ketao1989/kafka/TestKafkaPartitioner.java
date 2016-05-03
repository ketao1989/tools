/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.kafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * @author tao.ke Date: 15/12/27 Time: 下午9:28
 */
public class TestKafkaPartitioner implements Partitioner {

    public TestKafkaPartitioner(VerifiableProperties props) {
    }

    public int partition(Object key, int numPartitions) {

        int keyInt = Integer.parseInt((String) key);

        System.out.println(numPartitions);

        return keyInt % numPartitions;

    }
}
