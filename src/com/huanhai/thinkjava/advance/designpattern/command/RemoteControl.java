package com.huanhai.thinkjava.advance.designpattern.command;

/**
 * @version 1.0
 * @Description: 遥控器，也就是服务类
 * @Author: 覃波
 * @Date: 2019/10/10
 */
public class RemoteControl {

    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;
    private Command undoCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }
    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }
    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }
    /**
     * 执行播放方法
     */
    public void play(){
        playCommand.execute();
        undoCommand=playCommand;
    }
    /**
     * 执行倒带方法
     */
    public void rewind(){
        rewindCommand.execute();
        undoCommand=playCommand;
    }
    /**
     * 执行播放方法
     */
    public void stop(){
        stopCommand.execute();
        undoCommand=playCommand;
    }
    /**
     * 撤销
     */
    public void upd0(){
        undoCommand.undo();
    }
}
