package com.huanhai.thinkjava.advance.designpattern.proxy;

/**
 * @version 1.0
 * @Description: 代理类
 * @Author: 覃波
 * @Date: 2019/9/16
 */
public class Proxy implements  IBehaviour{
    private IBehaviour proxy;

    @Override
    public void order() {
        if(proxy == null){
            proxy=new Taobao();
        }
        preRequest();
        proxy.order();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void postRequest()
    {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
