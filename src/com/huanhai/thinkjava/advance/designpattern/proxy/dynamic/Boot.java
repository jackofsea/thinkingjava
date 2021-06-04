package com.huanhai.thinkjava.advance.designpattern.proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态代理总结：
 * 1.动态代理必须实现接口
 * 2.JDK的动态代理会动态生成字节码文件加载在JVM中
 * 3.
 *
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class Boot {
    private static List<String> className = new ArrayList<>();
    private static List<Class<?>> classType = new ArrayList<>();

    public static void main(String[] args)  {
        className.add("com.huanhai.thinkjava.advance.designpattern.proxy.dynamic.Japan");
        className.add("com.huanhai.thinkjava.advance.designpattern.proxy.dynamic.Chinese");
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        People chinese = new Chinese();
        PeopleInvocationHandler invocationHandler = new PeopleInvocationHandler(chinese);
        People proxy = (People) Proxy.newProxyInstance(chinese.getClass().getClassLoader(), chinese.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello();
        ProxyInteeptor p=new ProxyInteeptor(chinese);
        Action a=new Persion();
        a.run();
//        a= (Action) p.getInstance();
//        a.run();


        System.out.println( Arrays.toString(People.class.getInterfaces()));
//        classType.add(Class.forName(className.get(0)));
//        classType.add(Class.forName(className.get(1)));
//        new ProxyInteeptor((People) classType.get(0).getConstructors()[0].newInstance(null)).getInstance().sayHello();
//        new ProxyInteeptor((People) classType.get(1).getConstructors()[0].newInstance(null)).getInstance().say();
    }
}
