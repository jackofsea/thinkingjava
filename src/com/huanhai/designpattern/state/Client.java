package com.huanhai.designpattern.state;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2019/9/22 22:19
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        ScoreContext account=new ScoreContext();
        System.out.println("学生成绩状态测试：");
        account.add(30);
        account.add(40);
        account.add(25);
        account.add(-15);
        account.add(-25);
    }
}
