package com.djx.learn.javabase.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dong jing xi
 * @date 2020/7/17 12:04
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        executorService.execute(() -> {
            try {
                System.out.println("ready");
                countDownLatch.await();
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println("one thread count ..");
                countDownLatch.countDown();
            });
        }

        executorService.shutdown();
    }


    public static class Driver {

        public static void main(String[] args) throws InterruptedException {
            int count = 10;

            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(count);

            for (int i = 0; i < count; i++) {
                new Thread(new Worker(startSignal, doneSignal), "thread-" + i).start();
            }

            System.out.println("start");
            startSignal.countDown();
            System.out.println("doing...");
            doneSignal.await();
            System.out.println("done");

        }
    }

    public static class Worker implements Runnable {

        private CountDownLatch startSignal;
        private CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {

            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void doWork() {
            System.out.println(Thread.currentThread().getName() + ", do");
        }
    }


}
