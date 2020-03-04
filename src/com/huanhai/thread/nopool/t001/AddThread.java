package com.huanhai.thread.nopool.t001;

public class AddThread implements Runnable {
    private Cash cash;

    public AddThread(Cash cash) {
        this.cash = cash;
    }

    @Override
    public void run() {
        for (int i=0;i<100000;i++){
            cash.add();
        }
    }
}
