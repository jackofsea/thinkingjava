package com.huanhai.thinkjava.base;

public class IntegerTest {
    public static void main(String[] args) {
        Integer n1= 12;
        Integer n2=12;
        //判断是否相等,使用equals为佳,上面代码等于调用了Integer.valueOf()方法
        System.out.println("n1==n2 "+(n1==n2) +"   "+"n1==n2 "+n1.equals(n2) );
        //指定的进制解析为整型
        System.out.println(Integer.valueOf("10",16) );
        //比较两个数大小，大于返回1，等于返回0，小于返回-1,下面是无符号比较
        System.out.println(Integer.compare(18,16));
        System.out.println(Integer.compareUnsigned(999999999,1656565));
        //自动解码，如16进制，8进制,返回Integer
        System.out.println(Integer.decode("0x1A"));
        System.out.println(Integer.decode("075"));
        //从系统配置文件读取key，转换为Integer
        System.setProperty("name","2121");
        System.out.println(Integer.getInteger("name")+"  "+Integer.getInteger("name2",11)+"  "+Integer.getInteger("name22",new Integer(12)) );


    }
}
