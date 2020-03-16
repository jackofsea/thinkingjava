package com.huanhai.thread.nopool.practise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description 处理16条日志打印
 * @Author 覃波
 * @Date 2020/3/15 22:05
 * @Version 1.0
 **/
public class LogTest {
    public static void main(String[] args) {
        System.out.println("begin: "+(System.currentTimeMillis()/1000));
        //优化日志打印的代码
//        for (int i = 0; i <16 ; i++) {
//            final String p=""+(i+1);
//            parseLog(p);
//        }
        //创建四个线程优化，加阻塞队列实现
        BlockingQueue<String> q=new ArrayBlockingQueue<>(16);
        for (int i = 0; i <4 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            String l=q.take();
                            parseLog(l);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }
        for (int i = 0; i <16 ; i++) {
            final String p=""+(i+1);
            try {
                q.put(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    public static void parseLog(String log)  {
        System.out.println(log+": "+(System.currentTimeMillis()/1000));
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){

        }

    }
}
