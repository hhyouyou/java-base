package com.djx.learn.javabase.concurrent;

import java.util.concurrent.*;

/**
 * @author dong jing xi
 * @date 2020/8/10 23:54
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        // test1();
        test();
    }

    public static void test() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("全部抵达"));

        ThreadPoolExecutor cycThreadPool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            cycThreadPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ": ready...");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + ": go...");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        cycThreadPool.shutdown();
    }


    public static void test1() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("ready...");
                    cyclicBarrier.await();
                    System.out.println("go!");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
