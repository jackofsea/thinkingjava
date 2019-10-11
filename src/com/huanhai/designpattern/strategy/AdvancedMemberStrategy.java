package com.huanhai.designpattern.strategy;

/**
 * @version 1.0
 * @Description: 高级会员
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class AdvancedMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
