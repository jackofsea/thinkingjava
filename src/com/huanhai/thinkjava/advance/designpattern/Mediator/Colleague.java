package com.huanhai.thinkjava.advance.designpattern.Mediator;

/**
 * @version 1.0
 * @Description: 抽象同事类
 * @Author: 覃波
 * @Date: 2019/10/14
 */
public abstract class Colleague {
    /**
     *  调停者
     */
    private Mediator mediator;
    /**
     * 构造函数
     */
    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
    /**
     * 获取当前同事类对应的调停者对象
     */
    public Mediator getMediator() {
        return mediator;
    }
}
