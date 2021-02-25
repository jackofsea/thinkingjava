package com.huanhai.test;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @Description 初始化顺序测试
 * @Author 覃波
 * @Date 2020/4/21 8:42
 * @Version 1.0
 **/
public class InitTest {

    public static void main(String[] args) {
        String str1=new StringBuilder("计算机").append("软件").toString();
        String str2="计算机"+"软件";
        String str5=new String("计算机软件");
       // System.out.println(str1.intern() == str5.intern());
        System.out.println(str1.intern() == str1);
       String s4="计算机软件";
        System.out.println(str2==s4);
       System.out.println(str5.intern()==s4);
//        System.out.println(str1==str5);
//        String str2=new StringBuilder("java").append("va").toString();
//        System.out.println(str2.intern()==str2);
            new Dog("小三").say();





    }


    public static String getRandomJianHan(int len)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            String str = null;
            int hightPos, lowPos;
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39)));
            lowPos = (161 + Math.abs(random.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try
            {
                str = new String(b, "GBk");
            }
            catch (UnsupportedEncodingException ex)
            {
                ex.printStackTrace();
            }
            sb.append(str);
        }
        return sb.toString();
    }

}

class Dog extends Teacher{
    private String name;
    public Dog(String name){
        name=this.name;
    }

    @Override
    public String toString() {
        return "Dog{" +super.toString();
    }
}
