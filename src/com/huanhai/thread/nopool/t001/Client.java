package com.huanhai.thread.nopool.t001;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    public volatile static boolean flag=false;
    public static void main(String[] args) {
        Cash c = new Cash();
        ThreadGroup g = new ThreadGroup("tes");


        for (int i = 0; i < 10; i++) {
            new Thread(g, new AddAtomicThread(c)).start();
        }
//        Thread t2 = new Thread(g, new SubThread(c));
//        t1.start();
//        t2.start();
//        System.out.println("存活：" + g.activeCount());
//        try {
//            t2.join();
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        System.out.println("结果" + c.getNow());
        //flag不加volatile或者不做同步处理，线程将永远不会结束
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (!flag){
                    i++;
                }
            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            flag=true;
            System.out.println(c.addAtomic());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Cash {
    private int now = 0;
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    private static final int flag=getFlag();
    public static int getFlag(){
        System.out.println("flag初始化");
        return 2;
    }

    public synchronized void add() {
        this.now++;
    }

    public synchronized void sub() {
        this.now--;
    }
    public int addAtomic(){
        return atomicInteger.incrementAndGet();
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }
}

class AddThread implements Runnable {
    private Cash cash;

    public AddThread(Cash cash) {
        this.cash = cash;
    }

    @Override
    public void run() {
        String s;
        for (int i = 0; i < 10000; i++) {
            cash.add();
        }
    }
}


class AddAtomicThread implements Runnable {
    private Cash cash;

    public AddAtomicThread(Cash cash) {
        this.cash = cash;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            cash.addAtomic();
        }
    }
}


