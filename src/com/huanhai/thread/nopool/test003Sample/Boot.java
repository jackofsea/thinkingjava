package com.huanhai.thread.nopool.test003Sample;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Boot {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        for(int i=0;i<8;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"抢票一张");
                semaphore.release();
            }).start();
        }
    }
}
