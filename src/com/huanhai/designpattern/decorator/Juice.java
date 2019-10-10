package com.huanhai.designpattern.decorator;

/**
 * @version 1.0
 * @Description: 果汁
 * @Author: 覃波
 * @Date: 2019/9/5
 */
public class Juice implements IValuation {
    private IValuation  condiment;
    public Juice(IValuation  condiment){
        this.condiment=condiment;
    }
    @Override
    public float cost() {
        return 1.1f+condiment.cost();
    }
}
