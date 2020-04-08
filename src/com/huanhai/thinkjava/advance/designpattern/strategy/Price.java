package com.huanhai.thinkjava.advance.designpattern.strategy;

/**
 * @version 1.0
 * @Description: 价格类
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class Price {
    /**
     * 策略对象
     */
    private MemberStrategy strategy;
    /**
     * 构造函数，传入一个具体的策略对象
     * @param strategy    具体的策略对象
     */
    public Price(MemberStrategy strategy){
        this.strategy = strategy;
    }

    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }

}
