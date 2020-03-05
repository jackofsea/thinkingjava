package com.huanhai.thread.nopool.t001;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Computer {
    public static void main(String[] args) {
        Account account=new Account();
        for (int i=0;i<100;i++){
           Thread t=new Thread(new TaskThread(account));
           t.start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结果："+account.getAllAccont());
    }
}

class Account{
    private double allAccont=5000;
    private Lock lock=new ReentrantLock();
    public void add(double f){
        lock.lock();
        try {
            allAccont+=f;
        }finally {
            lock.unlock();
        }
    }
    public double getAllAccont(){
        return allAccont;
    }
}

class TaskThread implements Runnable{
   private Account account;

    public TaskThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            account.add(1);
        }
    }
}
