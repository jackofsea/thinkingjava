package com.huanhai.designPattern.command;

/**
 * 抽象命令
 *
 *
 */
public interface Command {
    /**
     * 执行方法
     */
    void execute();

    /**
     * 撤销
     */
    void undo();
}
