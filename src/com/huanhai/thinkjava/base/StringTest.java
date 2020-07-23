package com.huanhai.thinkjava.base;

/**
 *
 *  String的熟悉
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/7/23 14:56
 **/
public class StringTest {
    public static void main(String[] args) {
        valueOf();
    }

    private static void valueOf(){
        String s="2323";
        String s2="2323";
        String s3=new String("2323");
        System.out.println("s==s2:"+(s==s2));
        System.out.println("s==s3:"+(s==s3));
    }
}
