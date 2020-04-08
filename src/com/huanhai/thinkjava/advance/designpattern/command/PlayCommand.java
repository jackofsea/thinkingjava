package com.huanhai.thinkjava.advance.designpattern.command;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class PlayCommand implements Command {

    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        this.myAudio.play();
    }

    @Override
    public void undo() {
        this.myAudio.stop();
    }
}
