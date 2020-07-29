package com.djx.learn.javabase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dong jing xi
 * @date 2020/7/29 22:19
 **/
public class CreateThread {

    public static void main(String[] args) {
        // 1.继承 Thread
        Thread thread1 = new Thread(new Thread1(), "thread1");
        thread1.start();
        // 2.实现 Runnable
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();
        // 3.实现 Callable
        FutureTask<String> stringFutureTask = new FutureTask<>(new Thread3());
        Thread thread3 = new Thread(stringFutureTask, "thread3");
        thread3.start();
        try {
            String s = stringFutureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println(this.getClass().getName());
            super.run();
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println(this.getClass().getName());
        }
    }

    public static class Thread3 implements Callable<String> {
        @Override
        public String call() throws Exception {
            return this.getClass().getName();
        }
    }
}
