/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.thread;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: ketao Date: 14-5-3 Time: 下午4:51
 * @version: \$Id: ThreadTest.java 8 2015-02-07 06:02:21Z ketao1989 $
 */
public class ThreadTest {

    private static final ExecutorService executors = Executors.newFixedThreadPool(2);

    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 1200, TimeUnit.MICROSECONDS,
            new LinkedBlockingDeque<Runnable>());

    public static void main(String[] args) throws InterruptedException {
        //
        // Thread thread = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // while (true) {
        // try {
        // Thread.sleep(200);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // System.out.println("创建一个守护线程Deamon");
        // System.out.println(Thread.currentThread().getName());
        // }
        // }
        // }, "deamon-thread-1");
        //
        // thread.setDaemon(true);
        // thread.start();
        //
        // System.out.println("守护线程：  " + thread.isDaemon());
        //
        // Thread.sleep(1000);
        //
        // // AddShutdownHook方法增加JVM停止时要做处理事件：
        //
        // // 当JVM退出时，打印JVM Exit语句.
        // Runtime.getRuntime().addShutdownHook(new Thread() {
        // @Override
        // public void run() {
        // System.out.println("JVM Exit!");
        // }
        // });

        // System.out.println(Thread.currentThread().getName());
        //
        // Thread thread = new Thread(){
        // public void run(){
        // System.out.println("创建一个java线程");
        // System.out.println(Thread.currentThread().getName());
        // }
        // };
        //
        // thread.start();
        //
        // Thread thread1 = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // System.out.println("创建一个java线程");
        // System.out.println(Thread.currentThread().getName());
        // }
        // },"Thread==Runable=2");
        // thread1.start();

        List<String> list = Lists.newArrayList("thread-11", "thread-21", "thread-31", "thread-41");
        final List<String> results = Collections.synchronizedList(new ArrayList<String>());
        final CountDownLatch latch = new CountDownLatch(list.size());

        for (final String str : list) {
            executors.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);

                        results.add(str + "-test");
                        System.out.println(Thread.currentThread().getName());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        latch.await();
        //System.out.println(JSON.toJSONString(results));
        executors.shutdown();
    }
}
