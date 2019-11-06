package com.huanhai.designpattern.memento.whitebox;

/**
 *
 * 负责人角色类
 *
 * @author 覃波
 * @version 1.0
 * @date 2019/11/6
 */
public class Caretaker {
    private Memento memento;
    /**
     * 备忘录的取值方法
     */
    public Memento retrieveMemento(){
        return this.memento;
    }
    /**
     * 备忘录的赋值方法
     */
    public void saveMemento(Memento memento){
        this.memento = memento;
    }
}
