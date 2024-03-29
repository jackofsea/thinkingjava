package com.huanhai.thinkjava.advance.designpattern.state;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2019/9/22 22:15
 * @Version 1.0
 **/
public class LowState extends AbstractState {

    public LowState(ScoreContext h)
    {
        hj=h;
        stateName="不及格";
        score=0;
    }
    public LowState(AbstractState state)
    {
        hj=state.hj;
        stateName="不及格";
        score=state.score;
    }
    @Override
    public void checkState()
    {
        if(score>=90)
        {
            hj.setState(new HighState(this));
        }
        else if(score>=60)
        {
            hj.setState(new MiddleState(this));
        }
    }
}
