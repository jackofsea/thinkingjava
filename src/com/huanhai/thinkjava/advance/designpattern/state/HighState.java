package com.huanhai.thinkjava.advance.designpattern.state;

/**
 * @Description ToDo
 * @Author 覃波
 * @Date 2019/9/22 22:17
 * @Version 1.0
 **/
public class HighState extends AbstractState {
    public HighState(AbstractState state) {
        hj = state.hj;
        stateName = "优秀";
        score = state.score;
    }

    @Override
    public void checkState() {
        if (score < 60) {
            hj.setState(new LowState(this));
        } else if (score < 90) {
            hj.setState(new MiddleState(this));
        }
    }
}
