package com.djx.learn.javabase.concurrent;

/**
 * @author dong jing xi
 * @date 2020/9/11 0:28
 **/
public class NoVisibility {

    private static boolean ready;
    private static int number;


    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println("没看到呢");
                Thread.yield();
            }
            System.out.println(number);
        }
    }


    public static void main(String[] args) {
        new ReaderThread().start();
        ready = true;
        number = 1;  
    }


}
