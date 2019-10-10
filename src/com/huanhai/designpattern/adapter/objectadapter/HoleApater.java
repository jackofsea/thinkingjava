package com.huanhai.designpattern.adapter.objectadapter;

/**
 * @version 1.0
 * @Description: TO DO
 * @Author: 覃波
 * @Date: 2019/9/16
 */
public class HoleApater implements Twohole {
    private Socket socket;
    public HoleApater(Socket socket){
        this.socket=socket;
    }
    @Override
    public void getElectric(String x, String y) {
        socket.supplyElectric(x,y,null);
    }
}
