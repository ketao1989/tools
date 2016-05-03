/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * @author tao.ke Date: 15/7/29 Time: 下午10:36
 * @version \$Id$
 */
public class StringEventProducer {

    private final RingBuffer<StringEvent> ringBuffer;

    public StringEventProducer(RingBuffer<StringEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void produce(String value) {

        StringEventTranslator translator = new StringEventTranslator();
        translator.setValues(value);

        ringBuffer.publishEvent(translator);

        // long seq = ringBuffer.next();
        //
        // try {
        // StringEvent event = ringBuffer.get(seq);
        // event.setValue("test_"+value+"_end");
        // }finally {
        // ringBuffer.publish(seq);
        // }
    }
}
