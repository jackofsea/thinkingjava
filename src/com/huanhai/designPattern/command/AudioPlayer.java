package com.huanhai.designPattern.command;

/**
 * @version 1.0
 * @Description: 录音机
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class AudioPlayer {
    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }
}
