package com.huanhai.thread.nopool;


public class SubThread implements Runnable {
    private Cash cash;

    public SubThread(Cash cash) {
        this.cash = cash;
    }
    @Override
    public void run() {
        for (int i=0;i<99999;i++){
            cash.sub();
        }
    }
}
