package com.huanhai.designpattern.proxy;

/**
 * @version 1.0
 * @Description: 淘宝类
 * @Author: 覃波
 * @Date: 2019/9/16
 */
public class Taobao implements IBehaviour {
    @Override
    public void order() {
        System.out.println("淘宝替你下单！");
    }
}
