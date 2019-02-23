package com.self.learn.thread;

/**
 * @Author: chenbinbin
 */
public class ThreadDemo extends Thread{

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        ThreadDemo t3 = new ThreadDemo();
        t1.start();
        t2.start();
        t3.start();
    }
    @Override
    public void run() {
        System.out.println("ThreadDemo run....");
    }
}
