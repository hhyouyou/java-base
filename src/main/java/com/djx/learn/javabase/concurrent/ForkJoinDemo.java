package com.djx.learn.javabase.concurrent;

import java.util.concurrent.*;

/**
 * @author dong jing xi
 * @date 2020/8/13 10:34
 **/
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private final int threshold = 5;
    private int first;
    private int last;

    public ForkJoinDemo(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first <= threshold) {
            // 直接计算
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            // 拆分任务
            int middle = first + (last - first) / 2;
            ForkJoinDemo leftTask = new ForkJoinDemo(first, middle);
            ForkJoinDemo rightTask = new ForkJoinDemo(middle + 1, last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1, 10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(forkJoinDemo);
        System.out.println(submit.get());
    }
}
