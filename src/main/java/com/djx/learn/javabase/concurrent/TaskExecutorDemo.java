package com.djx.learn.javabase.concurrent;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author djx
 * @date 2021/6/2 下午2:08
 */
public class TaskExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        // 使用 threadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10
                , 10, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(10), r -> new Thread(r, "task-"), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new TaskThread("message:" + i));
        }

        //  使用ThreadPoolTaskScheduler 执行定时任务
        TaskThread taskThread = new TaskThread("message:");
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("task--");
        threadPoolTaskScheduler.initialize();

        threadPoolTaskScheduler.scheduleAtFixedRate(taskThread, 1000);

        Thread.sleep(10000);

    }

    @AllArgsConstructor
    @NoArgsConstructor
    static class TaskThread implements Runnable {

        private String message;

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + message);

        }
    }


}
