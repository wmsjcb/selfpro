package com.self.learn.thread;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: chenbinbin
 */
public class ReadWriteLockDemo {
    private static Map<String,Object> cacheMap = new HashMap<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock read =lock.readLock();
    static Lock write = lock.writeLock();

    public static final Object get(String key){
        System.out.println("开始获取读锁内容");
        read.lock();
        try {
            return cacheMap.get(key);
        }finally {
            read.unlock();
        }
    }

    public static  void put(String key ,Object value){
        System.out.println("开始写内容");
        write.lock();
        try {
            cacheMap.put(key,value);
        }finally {
         write.unlock();
        }

    }

    public static void main(String[] args) {
        ReadWriteLockDemo.put("time",new Date());
        Object obj = ReadWriteLockDemo.get("time");
        System.out.println(obj);
    }

}
