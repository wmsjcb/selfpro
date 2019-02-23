package com.self.learn.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: chenbinbin
 */
public class InterruptExceptionDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
             while (true){

                 try {
                     Thread.sleep(100000);
                 } catch (InterruptedException e) {
                     //抛出该异常，会将复位标识设置为false
                     e.printStackTrace();
                 }
             }
            }
        },"InterruptedDemo");
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();//设置复位标识为true
        TimeUnit.SECONDS.sleep(1);
        System.out.println(t.isInterrupted());//false
    }

}
