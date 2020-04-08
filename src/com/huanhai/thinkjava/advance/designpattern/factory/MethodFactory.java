package com.huanhai.thinkjava.advance.designpattern.factory;

/**
 * @version 1.0
 * @Description: 工厂方法
 * @Author: 覃波
 * @Date: 2019/8/28
 */
public class MethodFactory {
    public static void main(String[] args) {
        AbstractFactory fact=new MilkFatory();
        fact.getFood().show();
    }
}

class MilkFatory implements AbstractFactory{

    @Override
    public Food getFood() {
        return new Milk();
    }
}

class BreadFatory implements AbstractFactory{

    @Override
    public Food getFood() {
        return new Bread();
    }
}


