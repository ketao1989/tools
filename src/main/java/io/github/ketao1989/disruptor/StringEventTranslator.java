/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.disruptor;

import com.lmax.disruptor.EventTranslator;

/**
 * @author tao.ke Date: 15/7/29 Time: 下午10:52
 * @version \$Id$
 */
public class StringEventTranslator implements EventTranslator<StringEvent> {

    private String value;


    public void translateTo(StringEvent event, long sequence) {
        event.setValue(value);
        clear();
    }

    /**
     * For GC better
     */
    private void clear() {
        setValues(null);
    }

    /**
     * 设置构造完后对象的所有属性值
     * 
     * @param value
     */
    public void setValues(String value) {
        this.value = value;
    }
}
