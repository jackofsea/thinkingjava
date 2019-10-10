package com.huanhai.designpattern.decorator;

/**
 * @version 1.0
 * @Description: 牛奶
 * @Author: 覃波
 * @Date: 2019/9/5
 */
public class Milk implements IValuation {

    private IValuation  condiment;

    public Milk(IValuation  condiment){
        this.condiment=condiment;
    }
    @Override
    public float cost() {
        return 3.5f+condiment.cost();
    }
}
