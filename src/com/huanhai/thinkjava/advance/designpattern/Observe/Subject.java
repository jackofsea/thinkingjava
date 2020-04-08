package com.huanhai.thinkjava.advance.designpattern.Observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 抽象主题
 * @Author: 覃波
 * @Date: 2019/8/28
 */
abstract class Subject {
    protected List<Observer>  observerList= new ArrayList<>(16);

    public void add(Observer observer)
    {
        observerList.add(observer);
    }

    public void remove(Observer observer)
    {
        observerList.remove(observer);
    }
    public abstract void notifyObserver(); //通知观察者方法
}
