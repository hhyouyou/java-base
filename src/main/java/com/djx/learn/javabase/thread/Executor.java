package com.djx.learn.javabase.thread;

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

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new CreateThread.Thread2());
//        }
//        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService1.execute(new CreateThread.Thread2());
        }
        executorService1.shutdown();

    }
}
