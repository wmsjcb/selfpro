package com.self.learn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: chenbinbin
 */
public class ThreadNotifyWaitDemo {
    public static void main(String[] args) {
        Object obj = new Object();
        ThreadWait threadWait =  new ThreadWait(obj);
        ThreadNotify threadNotify =  new ThreadNotify(obj);
        threadWait.start();
        threadNotify.start();


    }
}
