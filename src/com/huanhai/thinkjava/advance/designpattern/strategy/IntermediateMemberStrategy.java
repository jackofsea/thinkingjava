package com.huanhai.thinkjava.advance.designpattern.strategy;

/**
 * @version 1.0
 * @Description: 中级会员
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}
