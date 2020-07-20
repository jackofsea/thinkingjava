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
        //打印进制字符
        toRadixString();
        //long的运算
        operation();
        //long的一些bit操作
        bitOperation();
        System.out.println(Long.toBinaryString(Long.MIN_VALUE));
        byte b=(byte) 0x80;
        System.out.println(b);
        System.out.println(Long.toBinaryString(b));
        //byte类型进行位移，二进制转为int范围，最后截取，确保准确要使用&0xff进行数值截取，如下
        byte s=-1;
        System.out.println(Long.toBinaryString(s));
        //错误做法：s>>>1
        byte b2= (byte) (((s&0xff)>>>1));
        System.out.println(b2);
        System.out.println(Long.toBinaryString(b2));


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
        //进制转换为Long，将对应的进制直接转为10进制的long,参数为解析的进制
        Long radix8=Long.valueOf("234",8);
        Long radix2=Long.valueOf("1011",2);
        System.out.println("radix8:"+radix8+" "+"radix2:"+radix2);
        //按指定进制解析将字符串转换为Long,不带参数默认按10进制转换
        long radix2p=Long.parseLong("044",8);
        long radix10=Long.parseLong("11123");
        System.out.println("radix2p:"+radix2p+" "+"radix10:"+radix10);
        //转换无符号的字符串
        System.out.println(Long.parseUnsignedLong("222"));
        System.out.println(Long.parseUnsignedLong("255",10));
        //返回余数
        System.out.println(Long.remainderUnsigned(10,7));
    }

    //Long转换为字符串
    public static void toRadixString() {
        //转换为二进制
        System.out.println(Long.toBinaryString(23245411111L));
        //转换为八进制
        System.out.println(Long.toOctalString(23245411111L));
        //转换为十六进制
        System.out.println(Long.toHexString(23245411111L));
        //转换为字符串
        System.out.println(new Long(34222219));
        //转换为无符号字符串
        System.out.println(Long.toUnsignedString(-3));
        System.out.println(Long.toUnsignedString(22,8));
    }

    //Long的一些运算,不推荐使用
    public static void operation() {
       //比较大小，底层用的Math类
        System.out.println(Long.max(2323,4444));
        System.out.println(Long.min(2323,4444));
        //求和
        System.out.println(Long.sum(2323,4444));
    }

    //Long的一些bit操作
    public static void bitOperation() {
        //signum,取得数值的符号函数，-1是负数，0是0,1是整数
        System.out.println(Long.signum(-32323));
        //bit位，取最高位bit的1表示的值
        System.out.println(Long.highestOneBit(-9223372036854775808L));
        System.out.println(Long.toBinaryString(-9223372036854775808L));
        //bit位，取最低位bit的1表示的值
        System.out.println(Long.lowestOneBit(-22));
        System.out.println(Long.toBinaryString(-22));
        //返回最左为1的bit为之前的0的数目
        System.out.println(Long.numberOfLeadingZeros(2));
        //返回最右为1的bit为之前的0的数目
        System.out.println(Long.numberOfTrailingZeros(2));
        //按bit位翻转
        System.out.println(Long.reverse(3));
        System.out.println(Long.toBinaryString(Long.reverse(3)));
        //按字节翻转
        System.out.println(Long.reverseBytes(3));
        System.out.println(Long.toBinaryString(Long.reverseBytes(3)));
        //循环左移N位或右移N位
        System.out.println(Long.rotateLeft(3,63));
        System.out.println(Long.toBinaryString(Long.rotateLeft(3,63)));
        System.out.println(Long.rotateRight(3,1));
        System.out.println(Long.toBinaryString(Long.rotateRight(3,1)));

    }


}
