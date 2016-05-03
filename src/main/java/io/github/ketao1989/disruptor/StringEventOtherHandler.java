/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author tao.ke Date: 15/7/29 Time: 下午11:20
 * @version \$Id$
 */
public class StringEventOtherHandler implements EventHandler<StringEvent> {


    public void onEvent(StringEvent event, long sequence, boolean endOfBatch) throws Exception {
        Thread.sleep(100);
        System.out.println("=======> " + event.getValue() + " <=======");
        System.out.println("=======> " + Thread.currentThread().getName() + " <=======");
    }
}
