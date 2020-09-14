package com.djx.learn.javabase.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dong jing xi
 * @date 2020/9/3 11:49
 **/
public class ThreadUnsafeDemo {

    public static class UnsafeIncrementDemo {
        private int cnt = 0;

        public void add() {
            cnt++;
        }
        public int get() {
            return cnt;
        }
    }

    public static class SafeIncrementDemo {
        private AtomicInteger cnt = new AtomicInteger(0);

        public void add() {
            cnt.incrementAndGet();
        }
        public int get() {
            return cnt.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeIncrementDemo unsafeIncrementDemo = new UnsafeIncrementDemo();
        SafeIncrementDemo safeIncrementDemo = new SafeIncrementDemo();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                unsafeIncrementDemo.add();
                safeIncrementDemo.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("unsafeIncrementDemo:" + unsafeIncrementDemo.get());
        System.out.println("safeIncrementDemo:" + safeIncrementDemo.get());
        executorService.shutdown();
    }
}
