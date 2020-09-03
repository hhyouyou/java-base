package com.djx.learn.javabase.io;

import lombok.Data;

import java.io.*;

/**
 * @author dong jing xi
 * @date 2020/8/26 19:45
 **/
public class ObjectSerializableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user = new User();
        user.setUsername("djx");
        user.setAge(100);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("").getAbsolutePath() + "/io/object"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("").getAbsolutePath() + "/io/object"));
        User user1 = (User) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(user1);


    }


    @Data
    public static class User implements Serializable {
        private String username;
        private Integer age;

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
