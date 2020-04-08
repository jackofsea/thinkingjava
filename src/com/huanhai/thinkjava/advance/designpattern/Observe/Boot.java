package com.huanhai.thinkjava.advance.designpattern.Observe;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/9/3
 */
public class Boot {
    public static void main(String[] args) {
        Subject t= new Teacher();
        Observer s1=new Student();
        Observer s2=new Student();
        t.add(s1);
        t.add(s2);
        t.notifyObserver();
        System.out.println(null == null);
    }
}
