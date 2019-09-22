package com.huanhai.designPattern.Iterator;

import java.util.List;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2019/9/22 21:39
 * @Version 1.0
 **/
public class ConcreteIterator implements Iterator {
    private List<Object> list=null;
    private int index=-1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }
    @Override
    public Object next() {
        Object o=list.get(++index);
        return o;
    }

    @Override
    public boolean hasNext() {
        if(list.size()-1>index){
           return true;
        }
        return false;
    }
}
