package com.huanhai.thinkjava.advance.designpattern.Mediator;

/**
 * @version 1.0
 * @Description: 显卡类
 * @Author: 覃波
 * @Date: 2019/10/14
 */
public class VideoCard extends Colleague {
    /**
     * 构造函数
     */
    public VideoCard(Mediator mediator) {
        super(mediator);
    }
    /**
     * 显示视频数据
     */
    public void showData(String data){
        System.out.println("您正在观看的是：" + data);
    }
}
