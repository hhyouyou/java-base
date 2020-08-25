package com.djx.learn.javabase.concurrent;

/**
 * @author dong jing xi
 * @date 2020/7/16 19:05
 **/
public class ThreadTest2 {

    /**
     * notify
     * 只唤醒了一个线程
     * <p>
     * notifyAll
     * 唤醒了所有线程
     */


    static final Object obj = new Object();

    static boolean flag = false;


    public static void main(String[] args) throws InterruptedException {

        Thread threadNotify = new Thread(new ThreadNotify(), "ThreadNotify");

        Thread threadWait2 = new Thread(new ThreadWait2(), "threadWait2");
        Thread threadWait1 = new Thread(new ThreadWait1(), "threadWait1");
        Thread threadWait3 = new Thread(new ThreadWait3(), "threadWait3");

        threadWait2.start();
        //Thread.sleep(2000);
        threadWait1.start();
//        Thread.sleep(2000);
        threadWait3.start();
//        Thread.sleep(2000);

        threadNotify.start();

    }


    static class ThreadWait1 implements Runnable {
        @Override
        public void run() {
            System.out.println("**************1****************");
            synchronized (obj) {
                System.out.println("进入线程1");
                try {
                    System.out.println("线程1开始等待");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1结束等待");
            }
            System.out.println("**************1****************");
        }
    }

    static class ThreadWait2 implements Runnable {
        @Override
        public void run() {
            System.out.println("***************2***************");
            synchronized (obj) {
                System.out.println("进入线程2");
                try {
                    System.out.println("线程2开始等待");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2结束等待");
            }
            System.out.println("***************2***************");
        }
    }

    static class ThreadWait3 implements Runnable {
        @Override
        public void run() {
            System.out.println("**************3****************");
            synchronized (obj) {
                System.out.println("进入线程3");
                try {
                    System.out.println("线程3开始等待");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程3结束等待");
            }
            System.out.println("**************3****************");
        }
    }

    static class ThreadNotify implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println("----开始停止等待----");
                obj.notifyAll();
//                obj.notify();
//                obj.notify();
                System.out.println("----调用停止等待----");
            }
        }
    }

}
