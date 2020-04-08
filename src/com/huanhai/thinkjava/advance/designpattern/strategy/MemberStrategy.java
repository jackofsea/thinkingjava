package com.huanhai.thinkjava.advance.designpattern.strategy;

/**
 * @version 1.0
 * @Description: 折扣
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public interface MemberStrategy {
    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
     double calcPrice(double booksPrice);
}
