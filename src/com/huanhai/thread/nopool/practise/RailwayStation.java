package com.huanhai.thread.nopool.practise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description 模拟抢票
 * @Author 覃波
 * @Date 2020/3/9 16:55
 * @Version 1.0
 **/
public class RailwayStation {
    public static void main(String[] args) throws InterruptedException {
        Ticket t=new Ticket();
        CountDownLatch c=new CountDownLatch(1);
        //模拟售票
        new Thread(new TicketOffice(t,"售票点1",true,c)).start();
        new Thread(new TicketOffice(t,"售票点2",true,c)).start();
        new Thread(new TicketOffice(t,"售票点3",true,c)).start();
        new Thread(new TicketOffice(t,"售票点4",true,c)).start();
        new Thread(new TicketOffice(t,"售票点5",true,c)).start();
        TimeUnit.SECONDS.sleep(1);
        c.countDown();


    }
}
class Ticket{
    private int total=100;
    public void subTicket(){
        synchronized (this){
            while (total<1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            total--;
            System.out.println("剩余："+this.total);
            notifyAll();
        }

    }

}
class TicketOffice implements Runnable{
    private Ticket ticket;
    private String name;
    private boolean run=true;
    private CountDownLatch countDownLatch;

    public TicketOffice(Ticket ticket, String name,boolean run,CountDownLatch countDownLatch) {
        this.ticket = ticket;
        this.name = name;
        this.run=run;
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           ticket.subTicket();
            System.out.println(name+"订了一张票");


    }
}

