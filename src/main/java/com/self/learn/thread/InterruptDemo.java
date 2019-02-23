package com.self.learn.thread;

/**
 * @Author: chenbinbin
 */
public class InterruptDemo {
    private static  int i;
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
             while (!Thread.currentThread().isInterrupted()){
               i++;
             }
                System.out.println("i的值："+i);
            }
        },"interruptDemo");

        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }

}
