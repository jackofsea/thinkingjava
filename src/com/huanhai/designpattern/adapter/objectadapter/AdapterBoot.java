package com.huanhai.designpattern.adapter.objectadapter;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/9/16
 */
public class AdapterBoot {
    public static void main(String[] args) {
        TV t=new TV("零线","火线");
        HoleApater apater=new HoleApater(new Socket());
        apater.getElectric(t.getX(),t.getY());
    }
}
