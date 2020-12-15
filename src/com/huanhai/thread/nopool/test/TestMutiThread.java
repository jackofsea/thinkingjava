package com.huanhai.thread.nopool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 覃波
 * @version 1.0
 * @date 2020-12-14 11:33
 **/
public class TestMutiThread implements Runnable {
    private static int i=0;
    private static volatile Integer vi=0;
    private static AtomicInteger ai=new AtomicInteger();
    //使用Integer作为对象锁是错误的
    private static Integer si=0;
    private static int ri=0;
    private static AtomicInteger flag=new AtomicInteger();
    private static Lock lock=new ReentrantLock();
    private static String s1="lock";
    @Override
    public void run() {
      for (int k=0;k<20000;k++){
           i++;
           vi++;
           ai.incrementAndGet();
           synchronized (s1){
               si++;
           }
           lock.lock();
           try {
               ri++;
           }finally {
               lock.unlock();
           }

      }
      flag.incrementAndGet();
    }

    public static void main(String[] args) {
        TestMutiThread ts1=new TestMutiThread();
        TestMutiThread ts2=new TestMutiThread();
        ExecutorService exe1=Executors.newCachedThreadPool();
        ExecutorService exe2=Executors.newCachedThreadPool();
        exe1.execute(ts1);
        exe2.execute(ts2);
        while (true){
            if(flag.intValue()==2){
                System.out.println("i>>>>"+i);
                System.out.println("vi>>>>"+vi);
                System.out.println("ai>>>>"+ai);
                System.out.println("si>>>>"+si);
                System.out.println("ri>>>>"+ri);
                break;
            }
        }
        System.out.println("主线程执行结束！");
    }
}
