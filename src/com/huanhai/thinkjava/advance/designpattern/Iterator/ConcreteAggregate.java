package com.huanhai.thinkjava.advance.designpattern.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2019/9/22 21:36
 * @Version 1.0
 **/
public class ConcreteAggregate implements Aggregate {
    private List<Object> list=new ArrayList<>(16);
    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
       list.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }
}
