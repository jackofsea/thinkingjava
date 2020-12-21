package com.huanhai.thread.nopool.test;

import java.util.concurrent.TimeUnit;

/**
 * 测试多线程间的可见性
 * @author 覃波
 * @version 1.0
 * @date 2020-12-14 11:13
 **/
public class PriceBoot {


    public static  boolean flag=true;
    public static void main(String[] args) throws InterruptedException {
//      Thread t=testThread();
//      while (!t.isAlive()){
//          t=testThread();
//          TimeUnit.MILLISECONDS.sleep(300);
//      }
        testJIT();




        System.out.println("主线程运行结束");
    }

    static Thread testThread() throws InterruptedException {
        Price p=new Price();
        p.setStop(true);
       Thread thread= new Thread(p);
        thread.start();
        Thread.sleep(100);
        new Thread(()->{ p.setStop(false);
            System.out.println("修改了p"+Thread.currentThread().getName());}
        ).start();

        Thread.sleep(100);
        return thread;
    }

    static void testJIT(){
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag=false;
            System.out.println("线程启动！");
        }).start();
        while (flag){
            System.out.println("测试循环！");
        }

    }
}
