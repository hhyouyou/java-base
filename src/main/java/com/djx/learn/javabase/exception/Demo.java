package com.djx.learn.javabase.exception;

/**
 * @author djx
 * @date 2022/9/19 下午3:58
 */
public class Demo {

    public static void main(String[] args) {


        try {
            throw new SonException();
        } catch (SonException e) {
            e.printStackTrace();
            System.out.println("SonException");
        } catch (ParentException e) {
            e.printStackTrace();
            System.out.println("ParentException");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

        System.out.println("end");

    }


}


class ParentException extends RuntimeException {
}

class SonException extends ParentException {
}
