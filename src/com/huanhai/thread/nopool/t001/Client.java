package com.huanhai.thread.nopool.t001;

public class Client {
    public static void main(String[] args) {
        Cash c=new Cash();
        ThreadGroup g=new ThreadGroup("tes");

        Thread t1=new Thread(g,new AddThread(c));
        Thread t2=new Thread(g,new SubThread(c));
        t1.start();
        t2.start();
        System.out.println("存活："+g.activeCount());
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结果"+c.getNow());
    }
}
