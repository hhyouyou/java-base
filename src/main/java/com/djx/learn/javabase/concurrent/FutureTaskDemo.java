package com.djx.learn.javabase.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dong jing xi
 * @date 2020/8/12 0:32
 **/
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> vFutureTask = new FutureTask<>(() -> {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                result = result + i;
            }
            return result;
        });

        Thread thread = new Thread(vFutureTask);
        thread.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(vFutureTask.get());
    }
}
