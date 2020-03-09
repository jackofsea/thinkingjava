package com.huanhai.thread.nopool.practise;

/**
 * @Description 模拟抢票
 * @Author 覃波
 * @Date 2020/3/9 16:55
 * @Version 1.0
 **/
public class RailwayStation {
    public static void main(String[] args) {
        Ticket t=new Ticket();
        new Thread(new TicketOffice(t,"售票点1",true)).start();
        new Thread(new TicketOffice(t,"售票点2",true)).start();
        new Thread(new TicketOffice(t,"售票点3",true)).start();
        new Thread(new TicketOffice(t,"售票点4",true)).start();
        new Thread(new TicketOffice(t,"售票点5",true)).start();


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

    public TicketOffice(Ticket ticket, String name,boolean run) {
        this.ticket = ticket;
        this.name = name;
        this.run=run;
    }

    @Override
    public void run() {
        while (run){
            ticket.subTicket();
            System.out.println(name+"订了一张票");
        }

    }
}

