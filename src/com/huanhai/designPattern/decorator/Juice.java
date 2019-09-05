package com.huanhai.designPattern.decorator;

/**
 * @version 1.0
 * @Description: 果汁
 * @Author: 覃波
 * @Date: 2019/9/5
 */
public class Juice implements IValuation {
    @Override
    public float cost() {
        return 1.1f;
    }
}
