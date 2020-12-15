package com.huanhai.thread.nopool.test;

/**
 * @author 覃波
 * @version 1.0
 * @date 2020-12-14 11:13
 **/
public class Boot {
    public static void main(String[] args) throws InterruptedException {
        Price p=new Price();
        p.setStop(true);
        new Thread(p).start();
//        for (int i=0;i<10;i++){
//            new Thread(p::add).start();
//        }
        Thread.sleep(2000);
        p.setStop(false);

        System.out.println("主线程运行结束");
    }
}
