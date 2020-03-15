package com.huanhai.thread.nopool.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @Description 哲学家吃饭问题
 * @Author 覃波
 * @Date 2020/3/12 23:02
 * @Version 1.0
 **/
public class PhilosopherTest {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < philosophers.length; i++) {
            Philosopher p = new Philosopher("哲学家" + i, i, "thinking");
            philosophers[i] = p;
        }
        philosophers[0].setState("eat");
        new Thread(new Eatservice(philosophers[0], philosophers[4], philosophers[1])).start();
        new Thread(new Eatservice(philosophers[1], philosophers[0], philosophers[2])).start();
        new Thread(new Eatservice(philosophers[2], philosophers[1], philosophers[3])).start();
        new Thread(new Eatservice(philosophers[3], philosophers[2], philosophers[4])).start();
        new Thread(new Eatservice(philosophers[4], philosophers[3], philosophers[0])).start();
        new Thread(new InputService(philosophers)).start();


    }
}

class Philosopher {
    private String name;
    private int num;
    private String state;
    private String rightHand = "1";
    private String leftHand = "0";
    private boolean isTerminate = false;

    public boolean getIsTerminate() {
        return isTerminate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Philosopher(String name, int num, String state) {
        this.name = name;
        this.num = num;
        this.state = state;
    }

    public synchronized void eating(Philosopher left, Philosopher right) {
        while (!"eat".equals(state) || !isHaveEnoughChopsticks(left, right)) {
            try {
                wait(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(name + "在吃饭！");
            TimeUnit.SECONDS.sleep(1);
            state = "thinking";
            isTerminate = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            notifyAll();
        }

    }

    public boolean isHaveEnoughChopsticks(Philosopher left, Philosopher right) {
        if ("1".equals(rightHand) || "1".equals(leftHand)) {
            if ("thinking".equals(left.state) && ("1".equals(left.rightHand) || "1".equals(left.leftHand))) {
                if (left.rightHand.contains("1")) {
                    left.rightHand = "0";
                } else {
                    left.leftHand = "0";
                }
                //获得筷子
                leftHand = "1";
                rightHand = "1";

                return true;
            } else if ("thinking".equals(right.state) && ("1".equals(right.rightHand) || "1".equals(right.leftHand))) {
                if (left.rightHand.contains("1")) {
                    left.rightHand = "0";
                } else {
                    left.leftHand = "0";
                }
                //获得筷子
                leftHand = "1";
                rightHand = "1";
                return true;
            }
            return false;

        } else {
            //双手都没有筷子
            List<String> hands = new ArrayList<>();
            hands.add(left.leftHand);
            hands.add(left.rightHand);
            hands.add(right.leftHand);
            hands.add(right.rightHand);
            long num = hands.stream().filter(s -> s.equals("1")).count();
            System.out.println("数量：" + num);
            if (num >= 2) {
                int j = 0;
                for (int i = 0; i < hands.size(); i++) {
                    if (hands.get(i).equals("1")) {
                        hands.set(i, "0");
                        j++;
                    }
                    if (j == 2) {
                        break;
                    }

                }
                rightHand = "1";
                leftHand = "1";
                left.leftHand = hands.get(0);
                left.rightHand = hands.get(1);
                right.leftHand = hands.get(2);
                right.rightHand = hands.get(3);

            }
            return false;
        }
    }

    @Override
    public String toString() {
        return
                name +
                        ", 状态='" + state +
                        ", rightHand='" + rightHand +
                        ", leftHand='" + leftHand +
                        ", 是否吃完=" + isTerminate;
    }
}

class Eatservice implements Runnable {
    private Philosopher philosopher;
    private Philosopher leftPhilosopher;
    private Philosopher rightPhilosopher;
    private boolean isRun = true;

    public Eatservice(Philosopher philosopher, Philosopher leftPhilosopher, Philosopher rightPhilosopher) {
        this.philosopher = philosopher;
        this.leftPhilosopher = leftPhilosopher;
        this.rightPhilosopher = rightPhilosopher;
    }

    @Override
    public void run() {
        while (isRun) {
            philosopher.eating(leftPhilosopher, rightPhilosopher);
            if (philosopher.getIsTerminate()) {
                isRun = false;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class InputService implements Runnable {
    private Philosopher[] philosophers;

    public InputService(Philosopher[] philosophers) {
        this.philosophers = philosophers;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入编号");
            int num = sc.nextInt();
            System.out.println("输入状态");
            String t = sc.next();
            System.out.println("状态已改变");
            philosophers[num].setState(t);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < philosophers.length; i++) {
                System.out.println(philosophers[i].toString());

            }
        }
    }
}
