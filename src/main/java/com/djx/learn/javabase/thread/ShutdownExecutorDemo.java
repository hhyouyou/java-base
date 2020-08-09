package com.djx.learn.javabase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dong jing xi
 * @date 2020/8/3 23:12
 **/
public class ShutdownExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 中断所有线程
        executorService.shutdownNow();
        System.out.println("main run");

        // 中断单个线程
        Future<?> submit = executorService.submit(() -> {

        });
        submit.cancel(true);

    }
}
