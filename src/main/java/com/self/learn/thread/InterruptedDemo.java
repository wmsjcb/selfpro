package com.self.learn.thread;

/**
 * @Author: chenbinbin
 */
public class InterruptedDemo {
    private static  int i;
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
             while (true){
                 boolean ii=Thread.currentThread().isInterrupted();
                 if(ii){
                     System.out.println("before:"+ii);
                     //对线程进行复位
                     Thread.interrupted();
                     System.out.println("after:"+Thread.currentThread().isInterrupted());
                 }
             }
                //System.out.println("i的值："+i);
            }
        },"InterruptedDemo");

        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }

}
