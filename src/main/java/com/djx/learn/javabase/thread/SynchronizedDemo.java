package com.djx.learn.javabase.thread;

import lombok.Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dong jing xi
 * @date 2020/8/3 23:51
 **/
public class SynchronizedDemo {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        SynchronizedDemo1 demo1 = new SynchronizedDemo1();
        SynchronizedDemo1 demo2 = new SynchronizedDemo1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> demo1.f1());
        executorService.execute(() -> demo2.f1());
        executorService.shutdown();
    }

    private static void test1() {
        SynchronizedDemo1 synchronizedDemo1 = new SynchronizedDemo1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedDemo1.f1());
        executorService.execute(() -> synchronizedDemo1.f1());
        executorService.shutdown();
    }

    static class SynchronizedDemo1 {
        public void f1() {
            synchronized (this) {
                for (int i = 0; i < 15; i++) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}

