package com.djx.learn.javabase.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author djx
 * @date 2022/10/19 下午2:29
 */
@Slf4j
public class TaskException {


    public static final ExecutorService executorService = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(50000), r -> new Thread(r, "send-msg-" + new AtomicInteger(0).incrementAndGet()));


    public static void main(String[] args) {

        Future<String> submit = executorService.submit(TaskException::throwException);

        String s = "";
        try {
            s = submit.get(3, TimeUnit.SECONDS);
        }  catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            throw new SendMsgException("获取发送消息响应失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new SendMsgException("获取发送消息响应失败");
        }

        log.info(s);

    }

    private static String throwException() {
        try {
            int i = 1 / 0;
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送消息失败");
            throw new SendMsgException(e.getMessage());
        } finally {
            log.info("test");
        }
    }


}
