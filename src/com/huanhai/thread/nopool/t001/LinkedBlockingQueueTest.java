package com.huanhai.thread.nopool.t001;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description LinkedBlockingQueue测试
 * @Author 覃波
 * @Date 2020/3/18 10:10
 * @Version 1.0
 **/
public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> b=new LinkedBlockingQueue<>(4);
        b.add("s1");
        b.add("s2");
        b.add("s3");
        b.add("s4");
        System.out.println(b.take());
        System.out.println(b.poll());
        System.out.println(b.remove());
        System.out.println(b.take());
        System.out.println("sd "+b.poll());
    }

}
