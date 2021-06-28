package com.djx.learn.javabase.concurrent;

/**
 * @author djx
 * @date 2021/6/1 上午11:10
 */
public class WaitAndNotify {

    static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {

        new Thread(new Thread1()).start();

//        Thread.sleep(2000);

        new Thread(new Thread2()).start();

    }


    static class Thread1 implements Runnable {

        @Override
        public void run() {

            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(this.getClass().getName() + ": " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        }
    }


    static class Thread2 implements Runnable {

        @Override
        public void run() {

            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(this.getClass().getName() + ": " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        }
    }


}
