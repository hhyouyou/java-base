package com.djx.learn.javabase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dong jing xi
 * @date 2020/8/9 22:31
 **/
public class AwaitSignalDemo {

    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    private void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition1.signalAll();
            System.out.println("before");
            condition2.signalAll();
            System.out.println("before");
        } finally {
            lock.unlock();
        }
        System.out.println();
    }

    private void after() {
        lock.lock();
        try {
            System.out.println("after");
            condition1.await();
            System.out.println("after");
            condition2.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalDemo awaitSignalDemo = new AwaitSignalDemo();
        executorService.execute(awaitSignalDemo::after);
        executorService.execute(awaitSignalDemo::before);
    }
}
