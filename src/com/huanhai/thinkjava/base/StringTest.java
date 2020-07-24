package com.huanhai.thinkjava.base;

import sun.nio.cs.ext.GBK;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
    //String的创建
    private static void valueOf(){
        //直接赋值等于调用valueOf,New则会在堆上分配
        String s="2323";
        String s2="2323";
        String s4=String.valueOf("2323");
        String s3=new String("2323");
        System.out.println("s==s2:"+(s==s2));
        System.out.println("s==s4:"+(s==s4));
        System.out.println("s==s3:"+(s==s3));
         s3=s3.intern();
        System.out.println(" 将s3调用intern后 s3==s： "+(s3==s));
        //将浮点数转换为String，有精度丢失
        String num=String.valueOf(4.556565776752222222D);
        System.out.println("将浮点数转换为String:"+num);
        System.out.println("将浮点数转换为String:"+4.556565776752222222);
        //指定编码，创建字符串,String的默认编码是UTF-8
        System.out.println("UTF-8:"+new String("你是是我都是1".getBytes(StandardCharsets.UTF_8)));
        System.out.println("UTF-8:"+new String("你是是我都是1".getBytes(Charset.forName("UTF-8"))));
        System.out.println("ISO_8859_1:"+new String("你是是我都是1".getBytes(StandardCharsets.ISO_8859_1)));
        System.out.println("US_ASCII:"+new String("你是是我都是1".getBytes(StandardCharsets.US_ASCII)));
        System.out.println("GBK:"+new String("你是是我都是1".getBytes(new GBK()),Charset.forName("GBK")));
        //以指定编码获得字节数组,其ISO_8859_1不能表示中文
        String codeStr="2343你23老师";
        byte[] utf_8=codeStr.getBytes();
        byte[] utf_16=codeStr.getBytes(StandardCharsets.UTF_16);
        byte[] utf_16BE=codeStr.getBytes(StandardCharsets.UTF_16BE);
        byte[] utf_16LE=codeStr.getBytes(StandardCharsets.UTF_16LE);
        byte[] iso_8859_1=codeStr.getBytes(StandardCharsets.ISO_8859_1);
        System.out.println("字节数组转化utf_8:"+new String(utf_8,StandardCharsets.UTF_8));
        System.out.println("字节数组转化utf_16:"+new String(utf_16,StandardCharsets.UTF_16));
        System.out.println("字节数组转化utf_16BE:"+new String(utf_16BE,StandardCharsets.UTF_16BE));
        System.out.println("字节数组转化utf_16LE:"+new String(utf_16LE,StandardCharsets.UTF_16LE));
        System.out.println("字节数组转化ISO_8859_1:"+new String(iso_8859_1,StandardCharsets.ISO_8859_1));



    }
}
