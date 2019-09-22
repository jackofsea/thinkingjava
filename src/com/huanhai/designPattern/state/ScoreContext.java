package com.huanhai.designPattern.state;

/**
 * @Description 环境
 * @Author 覃波
 * @Date 2019/9/22 22:14
 * @Version 1.0
 **/
public class ScoreContext {
    private AbstractState state;
    ScoreContext()
    {
        state=new LowState(this);
    }
    public void setState(AbstractState state)
    {
        this.state=state;
    }
    public AbstractState getState()
    {
        return state;
    }
    public void add(int score)
    {
        state.addScore(score);
    }
}
