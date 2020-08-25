package com.djx.learn.javabase.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author dong jing xi
 * @date 2020/8/25 16:49
 **/
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    public static void test1() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 读整行
        String s = bufferedReader.readLine();
        System.out.println("输出:" + s);
    }

    public static void test2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 读一个字符
        int read = bufferedReader.read();
        System.out.println("read:" + read);
        System.out.println("readChar:" + (char) read);
    }

}
