package com.djx.learn.javabase.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dong jing xi
 * @date 2020/7/17 12:04
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        executorService.execute(() -> {
            try {
                System.out.println("ready");
                countDownLatch.await();
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println("one thread count ..");
                countDownLatch.countDown();
            });
        }

        executorService.shutdown();
    }

}
