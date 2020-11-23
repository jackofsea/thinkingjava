package com.huanhai.thinkjava.base;

import java.util.List;

/**
 *
 * ThreadLocal的API熟悉
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/8/2 13:19
 **/
public class ThreadLocalTest {
    private static  ThreadLocal<String> namaStr=new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
         ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
         //设置对象
         threadLocal.set(5);
        namaStr.set("你是");
        //移除key和value,可以防止内存泄露
//        threadLocal.remove();
        int HASH_INCREMENT = 0x61c88647;
       for (int i=1;i<5;i++){
           System.out.println("循环"+i);
           int finalI = i;
           Thread t=new Thread(()->{
             threadLocal.set(finalI +1);
               System.out.println(namaStr.get());
         });
           t.start();

       }
    Thread.sleep(100);
        System.out.println(namaStr.get());
        //取得对象
        System.out.println(threadLocal.get());


    }

    public static void get(List<?> list){

        System.out.println(list.get(0) instanceof  Integer);
    }





}

class TestOrder extends Thread{

    private  Numbers numbers;

    public TestOrder(Numbers numbers){
        this.numbers=numbers;
    }

    @Override
    public void run() {
        while (!(numbers.a==0 && numbers.b==1)){
            numbers.add();
        }
        System.out.println("a="+numbers.a+" b="+numbers.b);
    }
}

class Numbers{
    public int a=1;
    public int b=0;


    public void add(){
        a=0;
        b=a;
    }

}