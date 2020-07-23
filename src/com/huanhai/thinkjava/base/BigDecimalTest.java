package com.huanhai.thinkjava.base;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * BigDecimal熟悉
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/7/22 16:10
 **/
public class BigDecimalTest {
    public static void main(String[] args) {
        valueOf();
        operation();
    }

    //BigDecimal的创建
    private static void valueOf() {
        //不推荐这种创建,浮点数在创建会有精度丢失
        BigDecimal b = BigDecimal.valueOf(3.44444343434f);
        BigDecimal b2 = BigDecimal.valueOf(23232);
        System.out.println("b=" + b + "  b2=" + b2);
        //将Long转换为小数
        BigDecimal b3 = BigDecimal.valueOf(232334332434344342L, 10);
        System.out.println("b3=" + b3);
        //传入字符串构造
        System.out.println(new BigDecimal(Float.toString(343.323f)));

    }

    //运算，构造BigDecimal，要使用String构造，使用double有精度损失
    private static void operation() {
        BigDecimal num1 = new BigDecimal(0.005);
        BigDecimal num2 = new BigDecimal(1000000);
        BigDecimal num3 = new BigDecimal(-1000000);
        //尽量用字符串的形式初始化
        BigDecimal num12 = new BigDecimal("0.005");
        BigDecimal num22 = new BigDecimal("1000000");
        BigDecimal num32 = new BigDecimal("-1000000");

        //加法
        BigDecimal result1 = num1.add(num2);
        BigDecimal result12 = num12.add(num22);
        //减法
        BigDecimal result2 = num1.subtract(num2);
        BigDecimal result22 = num12.subtract(num22);
        //乘法
        BigDecimal result3 = num1.multiply(num2);
        BigDecimal result32 = num12.multiply(num22);
        //绝对值
        BigDecimal result4 = num3.abs();
        BigDecimal result42 = num32.abs();
        //除法
        BigDecimal result5 = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
        BigDecimal result52 = num22.divide(num12,20,BigDecimal.ROUND_HALF_UP);

        System.out.println("加法用value结果："+result1);
        System.out.println("加法用string结果："+result12);

        System.out.println("减法value结果："+result2);
        System.out.println("减法用string结果："+result22);

        System.out.println("乘法用value结果："+result3);
        System.out.println("乘法用string结果："+result32);

        System.out.println("绝对值用value结果："+result4);
        System.out.println("绝对值用string结果："+result42);

        System.out.println("除法用value结果："+result5);
        System.out.println("除法用string结果："+result52);
        //使用MathContext控制精度，在MathContext.UNLIMITED下会抛出ArithmeticException，因为结果是个无限循环小数
        BigDecimal m1=new BigDecimal("232.344444");
        BigDecimal m2=new BigDecimal("10.1");
        System.out.println("DECIMAL32下 m1/m2= "+m1.divide(m2, MathContext.DECIMAL32));
        System.out.println("DECIMAL64下 m1/m2= "+m1.divide(m2, MathContext.DECIMAL64));
        System.out.println("DECIMAL128下 m1/m2= "+m1.divide(m2, MathContext.DECIMAL128));
        System.out.println("DECIMAL32下 m1-m2= "+m1.subtract(m2, MathContext.DECIMAL32));
        System.out.println("DECIMAL64下 m1-m2= "+m1.subtract(m2, MathContext.DECIMAL64));
        System.out.println("DECIMAL128下 m-+m2= "+m1.subtract(m2, MathContext.DECIMAL128));
        System.out.println("DECIMAL32下 m1+m2= "+m1.add(m2, MathContext.DECIMAL32));
        System.out.println("DECIMAL64下 m1+m2= "+m1.add(m2, MathContext.DECIMAL64));
        System.out.println("DECIMAL128下 m1+m2= "+m1.add(m2, MathContext.DECIMAL128));
        System.out.println("DECIMAL32下 m1*m2= "+m1.multiply(m2, MathContext.DECIMAL32));
        System.out.println("DECIMAL64下 m1*m2= "+m1.multiply(m2, MathContext.DECIMAL64));
        System.out.println("DECIMAL128下 m1*m2= "+m1.multiply(m2, MathContext.DECIMAL128));
        System.out.println("不使用bigdecimal,除法："+(232.344444D/10.1D));
        System.out.println("不使用bigdecimal,加法："+(232.344444D+10.1D));
        System.out.println("不使用bigdecimal,除法："+(232.344444D*10.1D));
        System.out.println("不使用bigdecimal,减法："+(232.344444D-10.1D));




    }


}
