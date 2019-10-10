package com.huanhai.designpattern.command;

/**
 * @version 1.0
 * @Description: 客户端
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class CommandBoot {
    public static void main(String[] args) {
        //创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        //创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
        //创建请求者对象
        RemoteControl keypad = new RemoteControl();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);
        //测试
        keypad.play();
        keypad.upd0();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
}
