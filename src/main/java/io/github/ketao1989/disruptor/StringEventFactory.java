/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author tao.ke Date: 15/7/29 Time: 下午10:25
 * @version \$Id$
 */
public class StringEventFactory implements EventFactory<StringEvent> {

    public StringEvent newInstance() {
        return new StringEvent();
    }
}
