package com.djx.learn.javabase.reflection;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author djx
 * @date 2021/3/2 下午3:01
 */
public class Demo {

    public static void main(String[] args) throws NoSuchFieldException {

        Phone phone = new Phone();
        phone.setName("tai he jin shou ji ");
        phone.setColor(" bling bling black ");

        Field name = phone.getClass().getDeclaredField("name");
        Class<?> type = name.getType();

    }

    @Data
    static class Phone {
        private String name;
        private String color;

        private void call(String num) {
            System.out.println("call: " + num);
        }
    }

}
