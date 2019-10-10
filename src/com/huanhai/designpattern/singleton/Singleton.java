package com.huanhai.designpattern.singleton;

/**
 * @version 1.0
 * @Description: 饿汉式单例
 * @Author: 覃波
 * @Date: 2019/8/28
 */
public class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
}
