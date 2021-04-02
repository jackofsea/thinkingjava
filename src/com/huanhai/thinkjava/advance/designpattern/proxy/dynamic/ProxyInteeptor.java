package com.huanhai.thinkjava.advance.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  JDK动态代理
 *
 * @author luofeng
 * @version 1.0
 * @date 2021-04-01 9:26
 **/
public class ProxyInteeptor implements InvocationHandler {

    private People people;

    public ProxyInteeptor(People people){
        this.people=people;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("23321------------");
        method.invoke(people,args);
        return null;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(ProxyInteeptor.class.getClassLoader(),new Class[]{People.class},new ProxyInteeptor(people));
    }
}
