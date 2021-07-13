package com.huanhai.thread.nopool.practise;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印
 */
public class Printer2 {

    public static void main(String[] args) {
        //锁方法
//        PrintABC printABC = new PrintABC();
//        Thread t1 = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                printABC.printA();
//            }
//        }
//
//        );
//        Thread t2 = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                printABC.printB();
//            }
//        });
//        t1.start();
//        t2.start();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t1.interrupt();
//        t2.interrupt();
        //无锁实现
//        PrintABC printABC2 = new PrintABC();
//        new Thread(() -> {
//            while (printABC2.getStr().length > printABC2.getIndex()) {
//                if (printABC2.getIndex() % 2 == 0 && printABC2.getStr().length > printABC2.getIndex()) {
//                    System.out.println(printABC2.getStr()[printABC2.getIndex()]);
//                    printABC2.setIndex(printABC2.getIndex() + 1);
//                }
//
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (printABC2.getStr().length > printABC2.getIndex()) {
//                if (printABC2.getIndex() % 2 != 0 && printABC2.getStr().length > printABC2.getIndex()) {
//                    System.out.println(printABC2.getStr()[printABC2.getIndex()]);
//                    printABC2.setIndex(printABC2.getIndex() + 1);
//                }
//            }
//        }).start();
        //lock实现
        PrintABC printABC3 = new PrintABC();
        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        printABC3.printA2();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        printABC3.printB2();
                    }
                }
        ).start();

    }


}

class PrintABC {
    private String[] str = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "f", "g", "h", "i", "j", "k", "l"};
    private volatile int index = 0;
    private AtomicInteger integer = new AtomicInteger(0);
    private Lock lock = new ReentrantLock();
    private Condition c01 =lock.newCondition();

    public String[] getStr() {
        return str;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    //同步方法
    public synchronized void printA() {
        try {
            while (index % 2 != 0) {
                wait();
            }
            if (index == str.length) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "  " + str[index]);
            index++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            notifyAll();
        }
    }

    public synchronized void printB() {
        try {
            while (index % 2 == 0) {
                wait();
            }
            if (index == str.length) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "  " + str[index]);
            index++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            notifyAll();
        }
    }

    //lock同步
    public void printA2() {
        lock.lock();
        try {
            if (index % 2 != 0) {
                c01.await();
            }
            if (index == str.length) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "1  " + str[index]);

            index++;
            c01.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB2() {
        lock.lock();
        try {
            if (index % 2 == 0) {
                c01.await();
            }
            if (index == str.length) {
                return;
            }

            System.out.println(Thread.currentThread().getName() + "  " + str[index]);
            index++;
            c01.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }
}