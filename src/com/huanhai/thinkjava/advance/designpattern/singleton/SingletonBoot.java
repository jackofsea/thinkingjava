package com.huanhai.thinkjava.advance.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例测试
 * @author 覃波
 * @version 1.0
 * @date 2020-12-21 12:18
 **/
public class SingletonBoot {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (int i=0;i<100;i++){
            new Thread(()-> System.out.println("测试"+LazySingleton.getInstance().hashCode())).start();
        }
        Class<?> c=LazySingleton.class;
        for (Constructor con: c.getDeclaredConstructors()) {
            con.setAccessible(true);
            System.out.println( con.newInstance().hashCode());
        }



    }
}
