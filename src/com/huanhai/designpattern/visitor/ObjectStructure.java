package com.huanhai.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 结构对象角色
 * @Author: 覃波
 * @Date: 2019/10/12
 */
public class ObjectStructure {
    private List<Node> nodes = new ArrayList<Node>();

    /**
     * 执行方法操作
     */
    public void action(Visitor visitor){

        for(Node node : nodes)
        {
            node.accept(visitor);
        }

    }
    /**
     * 添加一个新元素
     */
    public void add(Node node){
        nodes.add(node);
    }
}
