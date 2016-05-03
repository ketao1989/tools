/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author tao.ke Date: 15/7/29 Time: 下午11:07
 * @version \$Id$
 */
public class StringEventTest {

    public static void main(String[] args) throws InterruptedException {

        Executor executor = Executors.newFixedThreadPool(3);

        StringEventFactory eventFactory = new StringEventFactory();

        //Disruptor<StringEvent> disruptor = new Disruptor<StringEvent>(eventFactory,1024,executor);
        Disruptor<StringEvent> disruptor = new Disruptor<StringEvent>(eventFactory, 1024, executor,
                                                                      ProducerType.MULTI,
                                                                      new SleepingWaitStrategy());

        disruptor.handleEventsWith(new StringEventHandler());
        disruptor.handleEventsWith(new StringEventOtherHandler());
        disruptor.handleEventsWith(new StringEventOtherHandler());

        disruptor.start();

        RingBuffer<StringEvent> ringBuffer = disruptor.getRingBuffer();

        StringEventProducer eventProducer = new StringEventProducer(ringBuffer);

        for (int i = 0 ; i<1000;i++){

            System.out.println("------"+Thread.currentThread().getName()+"--------");
            eventProducer.produce(String.valueOf(i));

        }

        disruptor.shutdown();

    }
}
