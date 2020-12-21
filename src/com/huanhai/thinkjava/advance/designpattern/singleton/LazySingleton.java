package com.huanhai.thinkjava.advance.designpattern.singleton;

/**
 * 无volatile版本
 * @version 1.0
 * @Description: 懒汉式单例,采用DCL检查机制，防止多线程并发导致单例失败
 * @Author: 覃波
 * @Date: 2019/8/28
 */
public class LazySingleton {
    private static LazySingleton singleton;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        //if(singleton==null){
            synchronized (LazySingleton.class){
                if(singleton==null){
                    return singleton=new LazySingleton();
                }
                return singleton;
            }
       // }
        //return singleton;
    }
}
