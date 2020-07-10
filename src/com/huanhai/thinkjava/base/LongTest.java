package com.huanhai.thinkjava.base;

/**
 * @Description Long的API学习和熟悉
 * @Author 覃波
 * @Date 2020/4/20 12:20
 * @Version 1.0
 **/
public class LongTest {
    public static void main(String[] args) {
        //Long对象创建和进制转换
        valueOf();
    }

    //Long对象的静态创建
    public static void valueOf() {
        short s = 3333;
        byte b = 127;
        int i = 222222;
        long lon = 2323232323232323L;
        //等同于Long L1=s,编译后会自调用valueOf方法，也称自动装箱,会使用缓存-128至127
        Long L1 = Long.valueOf(s);
        Long L2 = Long.valueOf(b);
        Long L3 = Long.valueOf(i);
        Long L4 = Long.valueOf(lon);
        System.out.println("L1:"+L1+"L2:"+L2+"L3:"+L3+"L4:"+L4);
        //编译后调用队长xxValue()方法，下面代码等同于long long1=L1.intValue(),也称自动拆箱
        long long1=L1;
        //进制转换，将对应的进制直接转为10进制的long
        Long radix8=Long.valueOf("234",8);
        Long radix2=Long.valueOf("1011",2);
        Long radix22=Long.parseLong("1111",2);
        System.out.println("radix8:"+radix8+" "+"radix2:"+radix2+" "+"radix22:"+radix22);
    }
}
