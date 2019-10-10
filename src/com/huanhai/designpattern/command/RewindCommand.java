package com.huanhai.designpattern.command;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class RewindCommand implements Command {
    private AudioPlayer myAudio;
    public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
         this.myAudio.rewind();
    }

    @Override
    public void undo() {
        this.myAudio.play();
    }
}
