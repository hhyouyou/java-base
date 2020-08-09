package com.djx.learn.javabase.thread;

/**
 * 测试中断方法 Thread.interrupted()
 *
 * @author dong jing xi
 * @date 2020/8/3 23:02
 **/
public class TestInterrupted {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("123");
            }
            System.out.println("结束");
        });

        thread.start();
        thread.interrupt();
    }
}
