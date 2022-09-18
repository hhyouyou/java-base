package com.djx.learn.javabase.concurrent;

import java.util.concurrent.*;

/**
 * 创建线程 的几种方式
 *
 * @author dong jing xi
 * @date 2020/7/29 22:19
 **/
public class CreateThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.继承 Thread
        Thread thread1 = new Thread1();
        thread1.start();

        // 2.实现 Runnable
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();
        // 2. 匿名内部类实现Runnable接口
        new Thread(() -> System.out.println("thread run....")).start();


        // 3.使用Executors 实现, 使用Future 获取 callable 返回值
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new Thread3());
        // submit.get 方法会阻塞当前线程，直到得到结果。
        System.out.println(submit.get());
        try {
            // 所以 建议使用可以设置超时时间的重载get方法。
            System.out.println(submit.get(10, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            // 超时处理
            e.printStackTrace();
        }

        // 3. 使用 FutureTask 获取 callable返回值
        FutureTask<String> stringFutureTask = new FutureTask<>(new Thread3());
        executorService.submit(stringFutureTask);
        System.out.println(stringFutureTask.get());

        // 使用 FutureTask 直接提交 实现Runnable线程
        FutureTask<String> stringFutureTask1 = new FutureTask<>(new Thread2(), "ok");
        executorService.submit(stringFutureTask1);
        System.out.println(stringFutureTask1.get());

    }


    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println(this.getClass().getName());
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "---->" + this.getClass().getName());
        }
    }

    public static class Thread3 implements Callable<String> {
        @Override
        public String call() {
            return this.getClass().getName();
        }
    }
}
