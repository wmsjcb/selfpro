package com.self.learn.thread;

/**
 * @Author: chenbinbin
 */
public class RunnableDemo implements Runnable {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            Thread t = new Thread(new RunnableDemo(),"线程"+i);
            t.start();
        }
    }



    @Override
    public void run() {
        System.out.println("线程名称:"+Thread.currentThread().getName()+" RunnableDemo is run....");
    }
}
