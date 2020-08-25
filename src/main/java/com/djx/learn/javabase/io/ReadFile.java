package com.djx.learn.javabase.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author dong jing xi
 * @date 2020/8/1 21:57
 **/
public class ReadFile {

    private static final String URL = "https://www.baidu.com";

    public static void main(String[] args) {

        try {
            URL url = new URL(URL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
