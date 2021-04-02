package com.huanhai.thinkjava.advance.designpattern.proxy.dynamic;

/**
 * @author luofeng
 * @version 1.0
 * @date 2021-04-01 9:40
 **/
public class Japan implements  People {
    @Override
    public void sayHello() {
        System.out.println("日本");
    }
    @Override
    public void say() {
        System.out.println("你好111");
    }
}
