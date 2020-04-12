package com.huanhai.thinkjava.base;

public class IntegerTest {
    public static void main(String[] args) {
        Integer n1=12;
        Integer n2=12;
        //判断是否相等
        System.out.println("n1==n2 "+(n1==n2) +"   "+"n1==n2 "+n1.equals(n2) );
        //指定的进制解析为整型
        System.out.println(Integer.valueOf("10",16) );
        //
    }
}
