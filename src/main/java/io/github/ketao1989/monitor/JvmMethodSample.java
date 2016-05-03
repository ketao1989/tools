/*
 * Copyright (c) 2015 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.monitor;

import com.google.common.base.Ticker;
import io.github.ketao1989.jackson.JsonUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author tao.ke Date: 15/7/26 Time: 上午10:37
 * @version \$Id$
 */
public class JvmMethodSample {

    private static final Logger logger = LoggerFactory.getLogger(JvmMethodSample.class);

    /**
     * 保存监控数据
     */
    private static final ConcurrentHashMap<String, MonitorValue> dataMap = new ConcurrentHashMap<String, MonitorValue>();

    private static long lastTime = 0L;

    /**
     * 50秒的纳秒数
     */
    private static final long FIFTY_SECONDS_NANOS = TimeUnit.NANOSECONDS.convert(50, TimeUnit.SECONDS);

    /**
     * 单线程调度器
     */
    public static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    static {
        // scheduleAtFixedRate 保证一个任务执行完之后，一定delay之后，后一个任务才会执行
        // 而不会出现并发执行的情况

        executor.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {

                long cur = Ticker.systemTicker().read();

                if (cur - lastTime > FIFTY_SECONDS_NANOS) {
                    lastTime = cur;
                    return;
                }

                // // 每分钟前10秒内执行收集操作
                if (DateUtils.getFragmentInSeconds(new Date(TimeUnit.MILLISECONDS.convert(cur, TimeUnit.NANOSECONDS)),
                        Calendar.MINUTE) > 10) {
                    return;
                }

                try {
                    runTask();
                } catch (Exception e) {
                    logger.error("=-=-=-", e);
                }
            }
        }, 1, 2, TimeUnit.SECONDS);

    }

    private static void runTask() {

        // 线程数
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        addRecord("jvm_thread_count", mxBean.getThreadCount(), 0);

        // GC
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : gcBeans) {
            addRecord(bean.getName(), bean.getCollectionCount(), bean.getCollectionTime());
        }

        logger.info("-----------------");
        logger.info("{}---{}", JsonUtils.encode(dataMap.keySet()), JsonUtils.encode(dataMap.values()));

    }

    /**
     * 增加一个监控记录
     *
     * @param key
     * @param count
     * @param time 如果不存在则为0
     */
    private static void addRecord(String key, long count, long time) {

        MonitorValue value = getValueRef(key);
        synchronized (dataMap) {
            value.add(time, count);
        }
    }

    /**
     * 获取key对应的监控值
     *
     * @param key
     * @return
     */
    private static MonitorValue getValueRef(String key) {

        MonitorValue value = dataMap.get(key);

        if (value == null) {
            synchronized (dataMap) {
                if (dataMap.get(key) == null) {
                    value = new MonitorValue();
                    dataMap.put(key, value);
                }
            }
        }
        return value;
    }

    /**
     * 提供给外部添加监控记录
     * 
     * @param key
     * @param count
     */
    public static void recordOne(String key, int count) {
        addRecord(key, count, 0);
    }

    /**
     * 提供外部添加监控数量和时间
     * 
     * @param key
     * @param count
     * @param time
     */
    public static void recordOne(String key, int count, long time) {
        addRecord(key, count, time);
    }

    public static void main(String[] args) throws Exception {
        addRecord("test-custome", 1, 12);
    }
}
