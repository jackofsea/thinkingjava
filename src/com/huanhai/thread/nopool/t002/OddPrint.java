package com.huanhai.thread.nopool.t002;

/**
 * @author luofeng
 * @version 1.0
 * @date 2021-04-07 16:27
 **/
public class OddPrint {
    private volatile static int i = 0;
    private volatile static int n = 100;

    private synchronized void printOdd() {
        while (i < n) {
            try {
                while (i % 2 == 0 ) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " i==" + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                notifyAll();
            }
        }
    }

    private synchronized void printOx() {
        while (i < n) {
            try {
                while (i % 2 == 1 ) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " i==" + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                notifyAll();
            }
        }
    }

    static class OddPrint1 implements Runnable {
        private OddPrint oddPrint;

        public OddPrint1(OddPrint oddPrint) {
            this.oddPrint = oddPrint;
        }


        @Override
        public void run() {
            oddPrint.printOdd();

        }
    }

    static class OxPrint implements Runnable {
        private OddPrint oddPrint;

        public OxPrint(OddPrint oddPrint) {
            this.oddPrint = oddPrint;
        }

        @Override
        public void run() {
            oddPrint.printOx();

        }


    }

    public static void main(String[] args) {
        OddPrint oddPrint = new OddPrint();
        new Thread(new OxPrint(oddPrint)).start();
        new Thread(new OddPrint1(oddPrint)).start();
    }
}
