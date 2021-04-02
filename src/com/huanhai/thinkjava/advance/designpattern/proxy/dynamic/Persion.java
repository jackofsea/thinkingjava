package com.huanhai.thinkjava.advance.designpattern.proxy.dynamic;

/**
 * @author luofeng
 * @version 1.0
 * @date 2021-04-02 15:10
 **/
public class Persion implements Action {
    @Override
    public String run() {
        System.out.println("人在跑");
        return "人在跑";
    }
}
