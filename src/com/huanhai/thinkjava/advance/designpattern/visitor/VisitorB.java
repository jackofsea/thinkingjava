package com.huanhai.thinkjava.advance.designpattern.visitor;

/**
 * @version 1.0
 * @Description: 访问者B
 * @Author: 覃波
 * @Date: 2019/10/12
 */
public class VisitorB implements Visitor {
    /**
     * 对应于NodeA的访问操作
     */
    @Override
    public void visit(NodeA node) {
        System.out.println(node.operationA());
    }
    /**
     * 对应于NodeB的访问操作
     */
    @Override
    public void visit(NodeB node) {
        System.out.println(node.operationB());
    }
}
