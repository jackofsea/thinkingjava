package com.huanhai.designpattern.Iterator;

public interface Aggregate {
    void add(Object obj);
    void remove(Object obj);
    Iterator iterator();
}
