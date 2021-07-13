package com.huanhai.thread.pool.test1;

public class TreadA implements Runnable {

    PrintArg printArg;

    public TreadA(PrintArg printArg) {
        this.printArg = printArg;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程A开始任务");
        Prinf2();
        System.out.println("线程A结束任务");
    }

    public void Prinf1(){
       synchronized (printArg){
           printArg.prinf(printArg.getPos());
           printArg.setPos(printArg.getPos()+1);
           printArg.setFlag(false);
       }
    }


    //无锁
    public void Prinf2(){
        while (printArg.getPos() < printArg.getChars().length){
            if (printArg.getPos()%2==0 && printArg.getPos() < printArg.getChars().length){
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                printArg.prinf(printArg.getPos());
                printArg.setPos(printArg.getPos()+1);
            }

        }
    }
}
