/*
 * Copyright (c) 2015 taocoder.com. All Rights Reserved.
 */
package io.github.ketao1989.thread.scheduledPool;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author tao.ke Date: 16/5/3 Time: 下午6:38
 */
public class MyScheduledTest {

  public static BlockingQueue<String> stringBlockingQueue = new ArrayBlockingQueue<String>(1);

  public static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
  public static void main(String[] args) {
    String value;
    Runnable runnable = new Runnable() {
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };

    stringBlockingQueue.offer("aaaaaaa");
    int count = 0;

    try {
      while (StringUtils.isNoneEmpty(value = stringBlockingQueue.take())) {
        count++;
        service.schedule(runnable, 10L, TimeUnit.SECONDS);
        System.out.println(value);
      }

    } catch (Exception e) {

    } finally {
      stringBlockingQueue.offer("aaaaaa" + count);
    }

  }
}
