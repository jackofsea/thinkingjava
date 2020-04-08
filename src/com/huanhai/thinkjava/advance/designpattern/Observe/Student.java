package com.huanhai.thinkjava.advance.designpattern.Observe;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/9/3
 */
 class Student implements Observer {
    @Override
    public void response() {
        System.out.println("收到改变了");
    }
}
