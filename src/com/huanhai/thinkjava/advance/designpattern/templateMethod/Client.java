package com.huanhai.thinkjava.advance.designpattern.templateMethod;

import com.huanhai.thinkjava.advance.designpattern.visitor.*;

/**
 * @version 1.0
 * @Description: 客户端
 * @Author: 覃波
 * @Date: 2019/10/12
 */
public class Client {
    public static void main(String[] args) {
        //创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //给结构增加一个节点
        os.add(new NodeA());
        //给结构增加一个节点
        os.add(new NodeB());
        //创建一个访问者
        Visitor visitor = new VisitorA();
        os.action(visitor);
    }
}
