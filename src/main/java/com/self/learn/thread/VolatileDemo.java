package com.self.learn.thread;

/**
 * Created by chenbinbin1 on 2019/2/18.
 */
public class VolatileDemo {
 private static  volatile boolean  stop=false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            int i=0;
            @Override
            public void run() {
                while(!stop){
                  i++;
                }
                System.out.println("i="+i);
            }
        });
        thread.start();
        System.out.println("开始执行 Thread");
        Thread.sleep(1000);
        stop=true;

    }

}
