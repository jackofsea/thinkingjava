package com.huanhai.trade.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 *  交易核心线程池
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/5/28 19:30
 **/
public class TradeThreadPool {
    /**
     * 线程池
     */
    private ThreadPoolExecutor pool;
    /**
     * 线程池数量,和CPU核心数有关
     */
    private int threadSize=17;

    TradeThreadPool(){
        pool=new ThreadPoolExecutor(17,threadSize,0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(),new TradeThradFactory());
    }





}
