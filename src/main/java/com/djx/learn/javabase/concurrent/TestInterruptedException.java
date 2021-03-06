package com.djx.learn.javabase.concurrent;

/**
 * 测试中断异常 InterruptedException
 *
 * @author dong jing xi
 * @date 2020/8/3 22:50
 **/
public class TestInterruptedException {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread.interrupt();
        System.out.println("main run");
    }

}
