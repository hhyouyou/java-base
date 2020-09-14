package com.djx.learn.javabase.concurrent;

import org.apache.commons.lang.RandomStringUtils;

import java.util.concurrent.*;

/**
 * @author dong jing xi
 * @date 2020/8/12 23:50
 **/
public class BlockingQueueDemo {

    public static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        Thread producter = new Thread(() -> {
            String code = RandomStringUtils.randomNumeric(6);
            try {
                blockingQueue.put(code);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("producer(" + code + ")..");
        });

        Thread consumer = new Thread(() -> {
            String take = null;
            try {
                take = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consumer(" + take + ")...");
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producter);
        executorService.execute(producter);
        executorService.execute(producter);
        executorService.execute(consumer);
        executorService.execute(consumer);

        executorService.shutdown();
    }


}
