package com.huanhai.thread.nopool.t001;

public class Client {
    public static void main(String[] args) {
        Cash c = new Cash();
        ThreadGroup g = new ThreadGroup("tes");


        for (int i = 0; i < 100; i++) {
            new Thread(g, new AddThread(c)).start();
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
    }
}

class Cash {
    private int now = 0;

    public synchronized void add() {
        this.now++;
    }

    public synchronized void sub() {
        this.now--;
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


class SubThread implements Runnable {
    private Cash cash;

    public SubThread(Cash cash) {
        this.cash = cash;
    }

    @Override
    public void run() {
        for (int i = 0; i < 99999; i++) {
            cash.sub();
        }
    }
}
