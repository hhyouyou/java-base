package com.djx.learn.javabase.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 执行器
 *
 * @author dong jing xi
 * @date 2020/7/29 23:15
 **/
public class Executor {

    public static void main(String[] args) {
//        cached();
//        fixed();
        single();
    }

    public static void cached() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            executorService.execute(new CreateThread.Thread2());
        }
        executorService.shutdown();
    }

    public static void fixed() {
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            executorService1.execute(new CreateThread.Thread2());
        }
        executorService1.shutdown();
    }

    public static void single() {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 4; i++) {
            executorService1.execute(new CreateThread.Thread2());
        }
        executorService1.shutdown();
    }
}
