package com.huanhai.test;

/**
 * @author 覃波
 * @version 1.0
 * @date 2020/11/23 17:14
 **/
public class Memory {
    private volatile String maxLangth;
    public int ageOld=9;
    public static int age=10;

    public static void main(String[] args) {
        {
            byte[] a=new byte[64*1024*1024];
        }
        int b=0;
        System.out.println("结果："+getAgeSize1());
        System.gc();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int getAgeSize(){
        int a=12;
        int b=25;
        double c=b/a;
        System.out.println("agaOld:"+ageOld);
        return b;
    }

    public static int getAgeSize1(){
        int a=12;
        int b=25;
        double c=b/a;
        return b;
    }
    public static int getAgeSize1(String[] s){
        int a=12;
        int b=25;
        double c=b/a;
        return b;
    }
}
