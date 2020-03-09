package com.huanhai.thread.nopool.t001;

import java.util.concurrent.CountDownLatch;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2020/3/9 15:20
 * @Version 1.0
 **/
public class CountDownLatchTest {
    public static void main(String[] args)   {
        long s=System.nanoTime();
        CountDownLatch c =new CountDownLatch(2);
        Thread t1=new Thread(new TaskA(c));
        Thread t2=new Thread(new TaskB(c));
        t1.start();
        t2.start();
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始进行主线程");
        System.out.println((System.nanoTime()-s)/1000);
    }
}
class TaskA implements Runnable{
  private CountDownLatch countDownLatch;

    public TaskA(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("A初始化工作");
            for (int i = 0; i <10 ; i++) {
                System.out.println("testA");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();

        }
    }
}

class TaskB implements Runnable{
    private CountDownLatch countDownLatch;

    public TaskB(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {

            System.out.println("B初始化工作");
            for (int i = 0; i <44 ; i++) {
                System.out.println("testB");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
}
