package com.djx.learn.javabase.exception;


/**
 * @author djx
 * @date 2022/9/6 下午8:55
 */
public class SendMsgException extends RuntimeException {


    private final String msg;

    public SendMsgException(Throwable a, String message) {
        super(message, a);
        this.msg = message;
    }

    public SendMsgException(String message) {
        this(null, message);
    }

    public SendMsgException() {
        this(null, "send msg fail.");
    }

    public String getMsg() {
        return this.msg;
    }

}
