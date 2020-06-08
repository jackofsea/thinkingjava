package com.huanhai.trade.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 覃波
 * @version 1.0
 * @date 2020/6/4 17:28
 **/
public class TradeThradFactory implements ThreadFactory {

    /**
     * 线程池数目
     */
    private static  AtomicInteger poolNumber = new AtomicInteger(1);
    /**
     * 线程组
     */
    private  ThreadGroup group;
    /**
     * 线程数量
     */
    private  AtomicInteger threadNumber = new AtomicInteger(1);
    /**
     * 名称前缀
     */
    private  String namePrefix;

   TradeThradFactory(){
       group=Thread.currentThread().getThreadGroup();
       namePrefix = "trade-pool-" +
               poolNumber.getAndIncrement();
   }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon()){
            t.setDaemon(false);
        }

        if (t.getPriority() != Thread.NORM_PRIORITY){
            t.setPriority(Thread.NORM_PRIORITY);
        }

        return t;
    }
}
