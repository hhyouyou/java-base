package com.djx.learn.javabase.thread;

/**
 * @author dong jing xi
 * @date 2020/8/4 23:41
 **/
public class JoinDemo {

    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);

        b.start();
        a.start();
    }

    private static class A extends Thread {
        @Override
        public void run() {
            System.out.println("a");
        }
    }

    private static class B extends Thread {
        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
        }
    }

}
