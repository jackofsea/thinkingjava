package com.huanhai.designpattern.Mediator;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/14
 */
public class Cpu extends Colleague {
    //分解出来的视频数据
    private String videoData = "";
    //分解出来的声音数据
    private String soundData = "";
    /**
     * 构造函数
     */
    public Cpu(Mediator mediator) {
        super(mediator);
    }
    /**
     * 获取分解出来的视频数据
     */
    public String getVideoData() {
        return videoData;
    }
    /**
     * 获取分解出来的声音数据
     */
    public String getSoundData() {
        return soundData;
    }
    /**
     * 处理数据，把数据分成音频和视频的数据
     */
    public void executeData(String data){
        //把数据分解开，前面是视频数据，后面是音频数据
        String[] array = data.split(",");
        this.videoData = array[0];
        this.soundData = array[1];
        //通知主板，CPU完成工作
        getMediator().changed(this);
    }
}
