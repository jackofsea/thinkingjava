package com.huanhai.thread.nopool.practise;

import java.util.concurrent.TimeUnit;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2020/3/10 22:33
 * @Version 1.0
 **/
public class PrinterTest {
    public static void main(String[] args) {
        Printer p = new Printer();
        new Thread(new NumberPrinter(p)).start();
        new Thread(new LetterPrinter(p)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Printer {
    private int index = 1;

    public synchronized void print(int i) {

        try {
            while (index % 3 == 0) {
                wait();
            }
            System.out.print(i);
            index++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            notifyAll();
        }

    }

    public synchronized void print(char c) {
        try {
            while (index % 3 != 0) {
                wait();
            }
            System.out.print(c);
            index++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            notifyAll();
        }
    }
}

class NumberPrinter implements Runnable {
    private Printer p;

    public NumberPrinter(Printer p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i < 53; i++) {
            p.print(i);
        }
    }
}

class LetterPrinter implements Runnable {
    private Printer p;

    public LetterPrinter(Printer p) {
        this.p = p;
    }

    @Override
    public void run() {
        char[] c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'K', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z'};
        for (int i = 0; i < c.length; i++) {
            p.print(c[i]);
        }
    }
}