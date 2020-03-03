package com.huanhai.thread.nopool;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        Cash c=new Cash();
        Thread t1=new Thread(new AddThread(c));
        Thread t2=new Thread(new SubThread(c));
        t1.start();
        t2.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结果"+c.getNow());
    }
}
