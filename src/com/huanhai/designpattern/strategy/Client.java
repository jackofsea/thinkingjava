package com.huanhai.designpattern.strategy;

/**
 * @version 1.0
 * @Description: 客户端
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class Client {
    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        MemberStrategy strategy = new AdvancedMemberStrategy();
        //创建环境
        Price price = new Price(strategy);
        //计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
    }
}
