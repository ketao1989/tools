/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.excutors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @author tao.ke Date: 16/5/4 Time: 上午12:00
 */
public class MyDelayedQueue extends ScheduledThreadPoolExecutor {

    public MyDelayedQueue(int corePoolSize) {
        super(corePoolSize);
    }

    public MyDelayedQueue(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    public MyDelayedQueue(int corePoolSize, RejectedExecutionHandler handler) {
        super(corePoolSize, handler);
    }

    public MyDelayedQueue(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
    }
}
