package com.huanhai.thinkjava.advance.designpattern.visitor;

/**
 * @version 1.0
 * @Description: 节点A
 * @Author: 覃波
 * @Date: 2019/10/12
 */
public class NodeA extends Node {
    /**
     * 接受操作
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeA特有的方法
     */
    public String operationA(){
        return "NodeA";
    }

}
