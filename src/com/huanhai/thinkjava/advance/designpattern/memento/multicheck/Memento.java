package com.huanhai.thinkjava.advance.designpattern.memento.multicheck;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 覃波
 * @version 1.0
 * @date 2019/11/6
 */
public class Memento {
    private List<String> states;
    private int index;
    /**
     * 构造函数
     */
    public Memento(List<String> states , int index){
        this.states = new ArrayList<String>(states);
        this.index = index;
    }
    public List<String> getStates() {
        return states;
    }
    public int getIndex() {
        return index;
    }
}
