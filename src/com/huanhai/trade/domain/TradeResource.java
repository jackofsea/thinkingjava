package com.huanhai.trade.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 交易资源信息
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/6/5 14:56
 **/
public class TradeResource {

    private List resorces;

    private List offerList;

    public TradeResource(){
        resorces=new ArrayList(16);
        offerList=new LinkedList();
    }


}
