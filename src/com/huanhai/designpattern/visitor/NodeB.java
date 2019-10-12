package com.huanhai.designpattern.visitor;

/**
 * @version 1.0
 * @Description: 节点B
 * @Author: 覃波
 * @Date: 2019/10/12
 */
public class NodeB extends Node {

    /**
     * 接受方法
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * NodeB特有的方法
     */
    public String operationB(){
        return "NodeB";
    }
}
