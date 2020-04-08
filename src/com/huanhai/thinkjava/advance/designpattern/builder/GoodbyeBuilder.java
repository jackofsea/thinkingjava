package com.huanhai.thinkjava.advance.designpattern.builder;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class GoodbyeBuilder extends Builder {
    public GoodbyeBuilder(){
        msg = new GoodbyeMessage();
    }
    @Override
    public void buildBody() {
    msg.setBody("欢送内容");
    }

    @Override
    public void buildSubject() {
      msg.setSubject("欢送标题");
    }
}
