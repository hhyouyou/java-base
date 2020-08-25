package com.djx.learn.javabase.io;

import java.io.*;

/**
 * @author dong jing xi
 * @date 2020/8/26 0:52
 **/
public class CopyFileDemo {


    public static void main(String[] args) throws IOException {
        copyFile();
        copyFileNotBuffer();
    }

    public static void copyFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\dongj\\Desktop\\Spring 实战 第四版.pdf");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\dongj\\Desktop\\Spring实战.pdf");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];
        int read;
        long begin = System.currentTimeMillis();
        while ((read = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, read);
        }
        System.out.println("consuming:" + (System.currentTimeMillis() - begin));
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }


    public static void copyFileNotBuffer() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\dongj\\Desktop\\Spring 实战 第四版.pdf");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\dongj\\Desktop\\Spring实战1.pdf");
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];
        int read;
        long begin = System.currentTimeMillis();
        while ((read = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, read);
        }
        System.out.println("consuming:" + (System.currentTimeMillis() - begin));
        fileInputStream.close();
        fileOutputStream.close();
    }

}
