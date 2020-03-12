package com.huanhai.thread.nopool.practise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2020/3/11 15:49
 * @Version 1.0
 **/
public class CaveTest {
    public static void main(String[] args) {
        Cave c = new Cave();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Persion[] persions=new Persion[10];
        for (int i = 0; i <10 ; i++) {
            persions[i]=new Persion("张"+(i+1));
        }
       AtomicInteger atomicInteger=new AtomicInteger(1);
        for (int i = 0; i <persions.length ; i++) {
            PersionAndCave persionAndCave=new PersionAndCave(persions[i],c,atomicInteger);
            new Thread(new ThroughCave(persionAndCave,countDownLatch)).start();
        }
        countDownLatch.countDown();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Persion {
    private String name;

    public Persion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cave {
}

class PersionAndCave {
    private Persion persion;
    private Cave cave;
    private AtomicInteger index;

    public PersionAndCave(Persion persion, Cave cave,AtomicInteger index) {
        this.persion = persion;
        this.cave = cave;
        this.index=index;
    }
    public PersionAndCave( Cave cave ) {
        this.cave = cave;
    }
    public void setPersion(Persion persion) {
        this.persion = persion;
    }

    public  void throughCave() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(persion.getName() + "第" + index.getAndIncrement() + "个通过山洞");
    }

}

class ThroughCave implements Runnable {
    private PersionAndCave persionAndCave;
    private CountDownLatch countDownLatch;

    public ThroughCave(PersionAndCave persionAndCave, CountDownLatch countDownLatch) {
        this.persionAndCave = persionAndCave;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            persionAndCave.throughCave();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
