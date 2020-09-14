package com.djx.learn.javabase.concurrent;

import org.apache.commons.lang.RandomStringUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dong jing xi
 * @date 2020/9/4 10:37
 **/
public class ThreadPoolDemo {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), r -> new Thread(r, "线程-" + counter.incrementAndGet()), (r, executor) -> System.out.println("拒绝处理"));

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name + " run ...");
            });
        }

        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();

        threadPoolExecutor.shutdown();
    }
}
