/*
 * Copyright (c) 2015 taocoder.com. All Rights Reserved.
 */
package io.github.ketao1989.thread;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author tao.ke Date: 16/5/23 Time: 下午11:21
 */
public class ConsumerProducer {

    private int val;

    private volatile boolean hasVal = false;

    private final Object GET_LOCK = new Object();

    private final Object PUT_LOCK = new Object();


    public int getVal() throws InterruptedException {

        for (;;) {
            synchronized (GET_LOCK){
                if (hasVal) {
                    int v = val;
                    hasVal = false;
                    System.out.println("----"+ v);
                    return v;
                }
            }

        }

    }

    public  void setVal(int val) throws InterruptedException {
        for (;;) {
            synchronized (GET_LOCK){
                if (!hasVal) {
                    this.val = val;
                    hasVal = true;
                    System.out.println("----"+val);
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {

        final ConsumerProducer cp = new ConsumerProducer();



        new Thread(new Runnable() {
            public void run() {
               for (int a = 1;a<1000;a++){
                   try {
                       cp.setVal(a);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   try {
                       Thread.sleep(RandomUtils.nextLong(1,20));
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true){
                    int a = 0;
                    try {
                        a = cp.getVal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(RandomUtils.nextLong(1,20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
