package com.djx.learn.javabase.io;

import java.io.*;

/**
 * @author dong jing xi
 * @date 2020/8/25 20:13
 **/
public class FileWriterOrReaderDemo {

    public static void main(String[] args) throws IOException {

        fileWriter();
//        fileReader();
        fileReaderLine();

    }

    // 文件写入
    public static void fileWriter() throws IOException {
        // 写入的时候 是否覆盖文件内容
        // FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath() + "/io/file.txt");
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath() + "/io/file.txt", false);
        fileWriter.write("第一次写入");
        fileWriter.write("第二次写入");
        fileWriter.write("第三次写入\n测试换行\n再换个行");
        // append 和 writer相比，支持直接输入null
        fileWriter.append("append一下");
        fileWriter.append(null);

        // 查看文件编码
        fileWriter.flush();
        System.out.println("文件默认编码：" + fileWriter.getEncoding());
        fileWriter.close();
    }

    // 文件读取
    public static void fileReader() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath() + "/io/file.txt");
        int read;
        while ((read = fileReader.read()) != -1) {
            System.out.println(read);
            System.out.println((char) read);
        }
    }

    // 整行读取
    public static void fileReaderLine() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath() + "/io/file.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
    }

}
