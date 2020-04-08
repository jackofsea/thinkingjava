package com.huanhai.thinkjava.advance.designpattern.Mediator;

/**
 * @version 1.0
 * @Description: 声卡
 * @Author: 覃波
 * @Date: 2019/10/14
 */
public class SoundCard extends Colleague {
    /**
     * 构造函数
     */
    public SoundCard(Mediator mediator) {
        super(mediator);
    }
    /**
     * 按照声频数据发出声音
     */
    public void soundData(String data){
        System.out.println("画外音：" + data);
    }
}
