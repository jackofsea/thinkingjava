package com.huanhai.thread.nopool;

public class Cash {
    private  int now=10000000;

    public synchronized void add(){
        this.now++;
    }
    public synchronized void sub(){
        this.now--;
    }
    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

}
