package com.huanhai.thinkjava.advance.designpattern.state;

/**
 * @Description 抽象状态类
 * @Author 覃波
 * @Date 2019/9/22 22:13
 * @Version 1.0
 **/
public abstract class AbstractState {
    //环境
    protected ScoreContext hj;
    //状态名
    protected String stateName;
    //分数
    protected int score;
    public abstract void checkState(); //检查当前状态
    public void addScore(int x)
    {
        score+=x;
        System.out.print("加上："+x+"分，\t当前分数："+score );
        checkState();
        System.out.println("分，\t当前状态："+hj.getState().stateName);
    }
}
