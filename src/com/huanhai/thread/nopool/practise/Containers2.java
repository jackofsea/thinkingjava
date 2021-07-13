package com.huanhai.thread.nopool.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 对应6题，但是检测线程性能不好
 * 改进使用countDownLatch实现
 */
public class Containers2 {
    public static void main(String[] args) {
        Container2 container = new Container2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                container.add("2211");
            }
        }).start();
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (container.dectect()) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
        //改进
        Container2 container2 = new Container2();
        //5个为检测量
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                container2.add("2211");
                countDownLatch.countDown();

            }
        }).start();
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (container2.dectect()) {
                    Thread.currentThread().interrupt();
                }

            }
        }).start();
    }

}


class Container2 {
    private List<String> list = new ArrayList<>(32);


    public void add(String s) {
        System.out.println("加入");
        list.add(s);
    }

    public boolean dectect() {
        System.out.println("检测到数量到5个");
        if (list.size() == 5) {
            System.out.println("退出线程");
            return true;
        }
        return false;
    }


}

