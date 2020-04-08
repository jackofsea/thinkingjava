package com.huanhai.thinkjava.advance.designpattern.factory;

/**
 * @version 1.0
 * @Description: 牛奶类
 * @Author: 覃波
 * @Date: 2019/8/28
 */
public class Milk implements Food{
    private String name;
    @Override
    public void show() {
        System.out.println("这是牛奶");
    }
}
