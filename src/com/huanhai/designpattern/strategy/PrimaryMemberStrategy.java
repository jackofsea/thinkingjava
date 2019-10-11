package com.huanhai.designpattern.strategy;

/**
 * @version 1.0
 * @Description: 初级会员
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于初级会员的没有折扣");
        return booksPrice;
    }
}
