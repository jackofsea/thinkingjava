package com.huanhai.thinkjava.advance.designpattern.memento.blackbox;

/**
 *
 * 负责人角色
 * @author 覃波
 * @version 1.0
 * @date 2019/11/6
 */
public class Caretaker {
    private MementoIF memento;
    /**
     * 备忘录取值方法
     */
    public MementoIF retrieveMemento(){
        return memento;
    }
    /**
     * 备忘录赋值方法
     */
    public void saveMemento(MementoIF memento){
        this.memento = memento;
    }
}
