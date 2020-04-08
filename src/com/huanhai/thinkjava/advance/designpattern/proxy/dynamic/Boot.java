package com.huanhai.thinkjava.advance.designpattern.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class Boot {
    public static void main(String[] args) {
        People chinese = new Chinese();
        PeopleInvocationHandler invocationHandler = new PeopleInvocationHandler(chinese);
        People proxy = (People) Proxy.newProxyInstance(chinese.getClass().getClassLoader(), chinese.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello();
    }
}
