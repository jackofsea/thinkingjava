package com.huanhai.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class PeopleInvocationHandler implements InvocationHandler {

    private Object people;

    PeopleInvocationHandler(Object people){
        this.people = people;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(people, args);
        System.out.println("-------- end ---------");
        return invoke;
    }
}
