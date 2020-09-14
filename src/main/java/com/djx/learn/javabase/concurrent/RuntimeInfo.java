package com.djx.learn.javabase.concurrent;

/**
 * @author dong jing xi
 * @date 2020/9/5 14:44
 **/
public class RuntimeInfo {
    public static void main(String[] args) {
        /**
         * cpu核心线程数
         */
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        long l = Runtime.getRuntime().freeMemory();
        System.out.println(l);
    }
}
