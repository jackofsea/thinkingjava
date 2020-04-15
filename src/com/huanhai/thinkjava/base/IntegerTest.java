package com.huanhai.thinkjava.base;

public class IntegerTest {
    public static void main(String[] args) {
        Integer n1= 12;
        Integer n2=12;
        //判断是否相等,使用equals为佳, Integer n2=12代码等于调用了Integer.valueOf(12)方法
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
        //获得hashcode
        System.out.println(Integer.hashCode(34343));
        //highestOneBit,取最高比特位和最低比特位
        System.out.println(Integer.highestOneBit(5) + " "+Integer.lowestOneBit(5));
        //比较大小，底层采用的math函数做比较
        System.out.println(Integer.max(12,16)+"  "+Integer.min(12,16));
        //numberOfLeadingZeros(int i)暂时不懂有什么用
        System.out.println(Integer.numberOfLeadingZeros(2)+" "+ Integer.numberOfTrailingZeros(22));
        //字符串转换为Integer,默认是10进制,可选八进制，十六进制
        System.out.println(Integer.parseInt("23")+" "+Integer.parseInt("013",8));
        System.out.println(Integer.parseUnsignedInt("343444455")+" "+Integer.parseUnsignedInt("013",8));
        //返回无符号的余数
        System.out.println(Integer.remainderUnsigned(555,6));
        //bit序和字节序的颠倒
        System.out.println(Integer.reverse(2)+" "+Integer.reverseBytes(2));

        System.out.println(Integer.toBinaryString(33554432).length());





    }
}
