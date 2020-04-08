package com.huanhai.thinkjava.advance.designpattern.builder;

/**
 * @version 1.0
 * @Description: 客户端
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class Client {
    public static void main(String[] args) {

        Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("toAddress@126.com", "fromAddress@126.com");
    }
}
