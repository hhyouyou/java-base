package com.djx.learn.javabase.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author dong jing xi
 * @date 2020/8/25 19:51
 **/
public class FileStreamDemo {

    public static void main(String[] args) throws IOException {

        // output();
        // input();
        outputConverter();
        inputConverter();

    }


    public static void output() throws IOException {
        byte[] bytes = {11, 12, 13, 14, 15};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath() + "/io/test.txt");

        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }


    public static void input() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath() + "/io/test.txt");
        int c;
        while ((c = fileInputStream.read()) != -1) {
            System.out.println(c);
        }
    }


    // 文件读取写入，字节流、字符流转换，同时可以设置文件编码

    public static void outputConverter() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath() + "/io/test.txt");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        outputStreamWriter.write("第一行");
        outputStreamWriter.write("第二行");
        outputStreamWriter.flush();
        System.out.println("编码类型" + outputStreamWriter.getEncoding());
    }

    public static void inputConverter() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath() + "/io/test.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }

        bufferedReader.close();
    }


}
