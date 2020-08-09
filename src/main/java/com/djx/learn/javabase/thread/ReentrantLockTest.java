package com.djx.learn.javabase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dong jing xi
 * @date 2020/8/4 23:00
 **/
public class ReentrantLockTest {


    public static void main(String[] args) {
//        test1();
        test2();

    }

    private static void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantLockDemo demo1 = new ReentrantLockDemo();
        ReentrantLockDemo demo2 = new ReentrantLockDemo();
        executorService.execute(() -> demo1.test());
        executorService.execute(() -> demo2.test());
    }

    private static void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        executorService.execute(() -> reentrantLockDemo.test());
        executorService.execute(() -> reentrantLockDemo.test());
    }

    public static class ReentrantLockDemo {
        private Lock lock = new ReentrantLock();
        public void test() {
            lock.lock();
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.print(i + " ");
                }
            } finally {
                lock.unlock();
            }
        }
    }

}
