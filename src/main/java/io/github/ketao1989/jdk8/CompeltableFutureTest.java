package io.github.ketao1989.jdk8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author tao.ke Date: 2019/4/8 Time: 10:29 PM
 */
public class CompeltableFutureTest {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(
                () -> {
                    try {
                        System.out.println("start r1");
                        TimeUnit.SECONDS.sleep(1);
                        return "hello";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })

                .thenCombine(
                        CompletableFuture.supplyAsync(
                                () -> {
                                    try {
                                        System.out.println("start r2");
                                        TimeUnit.SECONDS.sleep(1);
                                        return " world";
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return null;
                                    }
                                }
                        ),

                        (r1, r2) -> {
                            try {
                                System.out.println("start r1 + r2");
                                TimeUnit.MICROSECONDS.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return r1 + r2 + "!!!!";
                        })

                .thenAccept(
                        (t) -> {
                            System.out.println("start accept");
                            System.out.println(t);
                        }
                );

        TimeUnit.SECONDS.sleep(3);
    }


}

