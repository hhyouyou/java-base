package com.djx.learn.javabase.concurrent;

/**
 * @author dong jing xi
 * @date 2020/7/16 19:05
 **/
public class ThreadTest1 {


    static final Object obj = new Object();

    /**
     * 判断该线程是否该等待，是否该唤醒
     */
    static boolean waitFlag = false;


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("AAAAAAAAAAAAAAAAAAA");
            synchronized (obj) {
                System.out.println("进入");
                if (!waitFlag) {
                    try {
                        System.out.println("开始等待");
                        obj.wait();
                        waitFlag = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("结束等待");
                System.out.println("1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("出来");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (obj) {
                if (waitFlag) {
                    System.out.println("开始停止等待");
                    obj.notify();
                    System.out.println("调用停止等待");

                }
                System.out.println("2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();

        thread2.start();


    }
}
