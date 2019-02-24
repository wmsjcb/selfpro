package com.self.learn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: chenbinbin
 */
public class ReentrantLockDemo {
    private static  int count=0;
    private static Lock lock = new ReentrantLock();
    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(1000);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<500;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ReentrantLockDemo.inc();
                }
            }).start();
        }
        Thread.sleep(4000);
        System.out.println("result:"+count);
    }

}
