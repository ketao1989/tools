package io.github.ketao1989.limit;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tao.ke Date: 2017/11/2 Time: 下午11:06
 */
public class LocalRateLimiter {

  /**
   * 保存限流key对应的token数据map
   */
  private static final ConcurrentHashMap<String, Token> TOKENS = new ConcurrentHashMap<>();

  private static final Object LOCK = new Object();

  public static void acquireToken(String key) {

    long nowSecond = System.currentTimeMillis() / 1000;

    Token token = TOKENS.get(key);

    if (token == null) {
      synchronized (LOCK) {
        if (TOKENS.get(key) == null) {
          TOKENS.putIfAbsent(key, new Token());
        }
      }
      token = TOKENS.get(key);
    }

    if (token.getToken(nowSecond).addAndGet(1) > 20) {
      System.out.println("ERROR 限流啦！！！" + key + "-----" + nowSecond);
      return;
    }

    System.out.println("SUCC 成功啦！！！" + key + "-----" + nowSecond);

  }

  private static class Token {

    /**
     * 两个token坑，时间戳秒取余来算
     */
    private AtomicInteger[] tokenNum = new AtomicInteger[2];

    private final Object lock = new Object();

    /**
     * 获取token，当切换新的token数组坑的时候，将上一个坑设置为null
     */
    public AtomicInteger getToken(long nowSeconds) {

      int pos = (int) (nowSeconds & 1);
      AtomicInteger tokens = tokenNum[pos];
      if (tokens == null) {
        synchronized (lock) {
          if (tokenNum[pos] == null) {
            tokenNum[pos] = new AtomicInteger(0);
            tokenNum[pos ^ 1] = null;
          }
        }
        tokens = tokenNum[pos];
      }
      return tokens;
    }
  }

  public static void main(String[] args) {

    new Thread(() -> {
      for (int i = 0; i < 200; i++) {
        acquireToken("test");
        try {
          TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(() -> {
      for (int i = 0; i < 200; i++) {
        acquireToken("test");
        try {
          TimeUnit.MILLISECONDS.sleep(40);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(() -> {
      for (int i = 0; i < 200; i++) {
        acquireToken("test");
        try {
          TimeUnit.MILLISECONDS.sleep(42);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(() -> {
      for (int i = 0; i < 200; i++) {
        acquireToken("test");
        try {
          TimeUnit.MILLISECONDS.sleep(45);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(() -> {
      for (int i = 0; i < 200; i++) {
        acquireToken("test");
        try {
          TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }

}
