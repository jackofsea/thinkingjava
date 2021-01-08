package com.huanhai.thread.nopool.test;

import java.util.HashMap;
import java.util.Map;

/**
 *  测试线程间的变量可见性
 * @author 覃波
 * @version 1.0
 * @date 2020-12-14 11:12
 **/
public class PriceRunnable implements Runnable {
    private int count;
    private  boolean stop;

    public synchronized int add() {

        for (int i=0;i<20000;i++){

                count++;
            }

        return count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isStop() {
        return stop;
    }

    public  void setStop(boolean stop) {
        this.stop = stop;
    }
    public  void stop() {
        this.stop =false;
    }

    public boolean getStop() {
        return this.stop ;
    }

    @Override
    public void run() {
        System.out.println("线程准备++++++"+Thread.currentThread().getName());
        Map<String,Integer> m=new HashMap<>();

            while (stop){
                m.put("1",2);

            }

        System.out.println("线程结束-----"+Thread.currentThread().getName());
    }
}
