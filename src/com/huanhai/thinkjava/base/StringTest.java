package com.huanhai.thinkjava.base;

import sun.nio.cs.ext.GBK;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;

/**
 * String的熟悉
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/7/23 14:56
 **/
public class StringTest {
    public static void main(String[] args) {
        valueOf();
        otherOperation();
    }

    //String的创建
    private static void valueOf() {
        //直接赋值等于调用valueOf,New则会在堆上分配
        String s = "2323";
        String s2 = "2323";
        String s4 = String.valueOf("2323");
        String s3 = new String("2323");
        System.out.println("s==s2:" + (s == s2));
        System.out.println("s==s4:" + (s == s4));
        System.out.println("s==s3:" + (s == s3));
        s3 = s3.intern();
        System.out.println(" 将s3调用intern后 s3==s： " + (s3 == s));
        //将浮点数转换为String，有精度丢失
        String num = String.valueOf(4.556565776752222222D);
        System.out.println("将浮点数转换为String:" + num);
        System.out.println("将浮点数转换为String:" + 4.556565776752222222);
        //指定编码，创建字符串,String的默认编码是UTF-8
        System.out.println("UTF-8:" + new String("你是是我都是1".getBytes(StandardCharsets.UTF_8)));
        System.out.println("UTF-8:" + new String("你是是我都是1".getBytes(Charset.forName("UTF-8"))));
        System.out.println("ISO_8859_1:" + new String("你是是我都是1".getBytes(StandardCharsets.ISO_8859_1)));
        System.out.println("US_ASCII:" + new String("你是是我都是1".getBytes(StandardCharsets.US_ASCII)));
        System.out.println("GBK:" + new String("你是是我都是1".getBytes(new GBK()), Charset.forName("GBK")));
        //以指定编码获得字节数组,其ISO_8859_1不能表示中文
        String codeStr = "2343你23老师";
        byte[] utf_8 = codeStr.getBytes();
        byte[] utf_16 = codeStr.getBytes(StandardCharsets.UTF_16);
        byte[] utf_16BE = codeStr.getBytes(StandardCharsets.UTF_16BE);
        byte[] utf_16LE = codeStr.getBytes(StandardCharsets.UTF_16LE);
        byte[] iso_8859_1 = codeStr.getBytes(StandardCharsets.ISO_8859_1);
        System.out.println("字节数组转化utf_8:" + new String(utf_8, StandardCharsets.UTF_8));
        System.out.println("字节数组转化utf_16:" + new String(utf_16, StandardCharsets.UTF_16));
        System.out.println("字节数组转化utf_16BE:" + new String(utf_16BE, StandardCharsets.UTF_16BE));
        System.out.println("字节数组转化utf_16LE:" + new String(utf_16LE, StandardCharsets.UTF_16LE));
        System.out.println("字节数组转化ISO_8859_1:" + new String(iso_8859_1, StandardCharsets.ISO_8859_1));
        //获得子串
        System.out.println("获得子串substring："+"你是收到后前往3332".substring(2));
        System.out.println("获得子串substring："+"你是收到后前往3332".substring(2,4));
        //转换大小写，,带Locale参数的为国际化
        System.out.println("转换大写upCase:"+"农四师dfDFeef ".toUpperCase());
        System.out.println("转换大写lowCase:"+"农四师dfDFeef ".toLowerCase());
        System.out.println("转换大写lowCase国际化:"+"农四师dfDFeef ".toLowerCase(Locale.FRENCH));
        //去掉前后空格
        System.out.println("去掉前后空格trim:"+"农四师dfDF eef ".trim());
    }

    //其他操作
    private static void otherOperation() {
        String exam = "你是1212Sdefef ";
        System.out.println("获取指定位置的字符串charAt(1):" + exam.charAt(1));
        System.out.println("判断是否包含contains(\"4343\"):" + exam.contains("4343"));
        System.out.println("判断是否包含contains(\"是1\"):" + exam.contains("是1"));
        System.out.println("以'你是1'开始startsWith：" + exam.startsWith("你是1"));
        System.out.println("以'你是1'结束endWith：" + exam.endsWith("你是1"));
        //只比较String
        System.out.println("判断是否相等equals："+exam.equals("ini1"));
        System.out.println("忽略大小写判断是否相等equals："+exam.equalsIgnoreCase("你是1212SDEFEF "));
        StringBuilder sd=new StringBuilder();
        sd.append(121);
        //比较字符序列CharSequence是否相等,范围比equals范围大
        System.out.println("判断是否相等contentEquals："+exam.contentEquals(sd));
        sd.delete(0,3);
        sd.append("你是1212Sdefef");
        System.out.println(sd);
        System.out.println("判断是否相等contentEquals："+exam.contentEquals(sd));
        System.out.println("字符串的长度length："+exam.length());
         //获得unicode的码位
        System.out.println("获得指定位置的码位(Unicode code point)codePointAt(1):" + exam.codePointAt(1));
        System.out.println("码位(Unicode code point)转换后的16进制字符串：\\u" + Integer.toUnsignedString(exam.codePointAt(1), 16));
        System.out.println("获得指定位置前一位的码位(Unicode code point)codePointAt(1):" + exam.codePointBefore(2));
        //String的正则匹配，一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\。
        exam = "你是1212Sdefef ";
        System.out.println("正则匹配matches： "+exam.matches("[\\u4e00-\\u9fa5]"));
        //字符串替换,还可以使用正则
        System.out.println("字符才替换replace："+exam.replace("你","你才是"));
        System.out.println("字符才替换replaceAll："+exam.replaceAll("e","测试"));
        //字符串格式化输出,带Locale参数的为国际化
        System.out.println(String.format("日志输出：%s,时间是：%s","开始打印",new Date()));
        System.out.println(String.format(Locale.FRENCH,"日志输出：%s,时间是：%s","开始打印",new Date()));


    }
}
