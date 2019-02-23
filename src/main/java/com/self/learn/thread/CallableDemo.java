package com.self.learn.thread;

import java.util.concurrent.*;

/**
 * @Author: chenbinbin
 */
public class CallableDemo implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> futures= executorService.submit(callableDemo);
        System.out.println(futures.get());
        executorService.shutdown();
    }


    @Override
    public String call() throws Exception {
        int a =1;
        int b=2;
        return "执行结果："+(a+b);
    }
}
