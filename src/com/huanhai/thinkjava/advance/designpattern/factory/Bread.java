package com.huanhai.thinkjava.advance.designpattern.factory;

/**
 * @version 1.0
 * @Description: 面包类
 * @Author: 覃波
 * @Date: 2019/8/28
 */
public class Bread implements Food{
    private String name;
    @Override
    public void show() {
        System.out.println("这是面包");
    }
}
