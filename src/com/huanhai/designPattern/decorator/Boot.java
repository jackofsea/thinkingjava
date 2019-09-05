package com.huanhai.designPattern.decorator;

/**
 * @version 1.0
 * @Description: 简单的装饰者
 * @Author: 覃波
 * @Date: 2019/9/5
 */
public class Boot {
    public static void main(String[] args) {
        IValuation juice=new Juice();
        IValuation milk=new Milk();
        IValuation coffee=new Coffee(juice);
        IValuation coffee2=new Coffee(coffee);
        System.out.println(coffee.cost());
        System.out.println(coffee2.cost());
    }
}
