package com.huanhai.designpattern.memento.whitebox;

/**
 *
 * 备忘录角色类
 * @author 覃波
 * @version 1.0
 * @date 2019/11/6
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
