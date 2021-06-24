package com.huanhai.thread.pool.test1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class boot {
    private static ExecutorService pool;

    public static void main(String[] args) {
        PrintArg arg = new PrintArg(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'});
        pool = new ThreadPoolExecutor(3, 4, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        pool.submit(new TreadA(arg));
        pool.submit(new TreadB(arg));
//        try {
//           TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        pool.submit(new TreadB(arg));
        pool.submit(new TreadB(arg));
//        pool.shutdown();
    }
}
