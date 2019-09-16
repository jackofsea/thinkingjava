package com.huanhai.designPattern.adapter.objectadapter;

/**
 * @version 1.0
 * @Description: 插座类
 * @Author: 覃波
 * @Date: 2019/9/16
 */
public class Socket implements ThreeHole {
    @Override
    public void supplyElectric(String x, String y, String z) {
        System.out.println("提供电力！");
    }
}
