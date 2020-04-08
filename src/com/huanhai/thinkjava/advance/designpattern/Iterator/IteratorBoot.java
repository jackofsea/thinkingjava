package com.huanhai.thinkjava.advance.designpattern.Iterator;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2019/9/22 21:45
 * @Version 1.0
 **/
public class IteratorBoot {
    public static void main(String[] args) {
        ConcreteAggregate s=new ConcreteAggregate();
        s.add("你是猪");
        s.add("测试");
        s.add("test");
        Iterator iterator=s.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
