package com.huanhai.thinkjava.advance.designpattern.decorator;

/**
 * @version 1.0
 * @Description: 简单的装饰者
 * @Author: 覃波
 * @Date: 2019/9/5
 */
public class Client {
    public static void main(String[] args) {
        IValuation coffee=new Coffee();
        IValuation juice=new Juice(coffee);
        IValuation milk=new Milk(juice);

        System.out.println("果汁味 "+juice.cost());
        System.out.println("果汁味 牛奶味 "+milk.cost());
    }
}
