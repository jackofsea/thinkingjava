package com.huanhai.designPattern.decorator;

/**
 * @version 1.0
 * @Description: 原味咖啡
 * @Author: 覃波
 * @Date: 2019/9/5
 */
public class Coffee  implements IValuation{
    private IValuation  condiment;
    public Coffee(IValuation condiment){
        this.condiment=condiment;
    }
    @Override
    public float cost() {
        return 2.5f+this.condiment.cost();
    }
}
