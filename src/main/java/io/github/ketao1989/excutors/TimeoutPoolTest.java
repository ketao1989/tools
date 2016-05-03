/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.excutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author tao.ke Date: 16/4/19 Time: 下午2:47
 */
public class TimeoutPoolTest {

  private static ExecutorService service = Executors.newFixedThreadPool(2);

  public static class AlwaysRun implements Callable<String> {

    private volatile boolean stop = false;

    public String call() {
      while (!stop){
        try {
          System.out.println(Thread.currentThread().getName());
          System.out.println("------sssss-------");
          Thread.sleep(10000);
          System.out.println("-------eeeeee------");
          return "test";
        } catch (InterruptedException e) {
          e.printStackTrace();
          throw new IllegalArgumentException("ssss222222");
        }

      }

      return "test-r";
    }

    public void changeVal(){
      stop=true;
    }

    public void interrupt() {
      System.out.println(Thread.currentThread().getName());
      Thread.currentThread().interrupt();
      stop=true;
      //service.shutdownNow();
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println(Thread.currentThread().getName());
    AlwaysRun alwaysRun = new AlwaysRun();


    try {
      Future<String> futureTask = service.submit(alwaysRun);
      String x = futureTask.get(200, TimeUnit.MILLISECONDS);
      System.out.println(x);
    }catch (TimeoutException e) {
      e.printStackTrace();
      alwaysRun.interrupt();
    }

    System.out.println("-------------------");

    service.submit(new Runnable() {
      public void run() {
        System.out.println("++++++++++++++++++++++++");
      }
    });

  }

}
