package com.huanhai.designpattern.decorator;

/**
 * @version 1.0
 * @Description: 原味咖啡
 * @Author: 覃波
 * @Date: 2019/9/5
 */
public class Coffee  implements IValuation{
    @Override
    public float cost() {
        return 2.5f;
    }
}
