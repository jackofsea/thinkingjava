package com.huanhai.thinkjava.advance.designpattern.Observe;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/9/3
 */
public class Teacher extends Subject {
    @Override
    public void notifyObserver() {
        for (Observer observer: observerList) {
            observer.response();
        }
    }
}
