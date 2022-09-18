package com.djx.learn.javabase.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author djx
 * @date 2022/9/15 上午11:23
 */
public class CountDownLatchDemo2 {


    static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {

            new Thread(() -> {
                try {
                    start.await();
                    for (int j = 0; j < 100; j++) {
                        count = count + 1;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }

            }).start();

        }

        start.countDown();
        end.await();

        System.out.println(count);

    }


}
