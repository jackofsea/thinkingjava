package com.huanhai.thread.pool.test1;

public class TreadB implements Runnable {

    PrintArg printArg;
    public TreadB(PrintArg printArg) {
        this.printArg = printArg;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程B开始任务");
        prinf2();
        System.out.println("线程B结束任务");
    }
    public void prinf1(){
        synchronized(printArg){
            printArg.prinf(printArg.getPos());
            printArg.setPos(printArg.getPos()+1);
            printArg.setFlag(true);
        }
    }
    //无锁
    public void prinf2(){
        while (printArg.getPos()< printArg.getChars().length ){
            if (printArg.getPos()%2==1 && printArg.getPos() < printArg.getChars().length){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                printArg.prinf(printArg.getPos());
                printArg.setPos(printArg.getPos()+1);

            }

        }
    }
}
