package com.huanhai.designpattern.prototype;

/**
 * @version 1.0
 * @Description: 金箍棒
 * @Author: 覃波
 * @Date: 2019/10/11
 */
public class GoldRingedStaff implements Cloneable {
    private float height = 100.0f;
    private float diameter = 10.0f;
    /**
     * 增长行为，每次调用长度和半径增加一倍
     */
    public void grow(){
        this.diameter *= 2;
        this.height *= 2;
    }
    /**
     * 缩小行为，每次调用长度和半径减少一半
     */
    public void shrink(){
        this.diameter /= 2;
        this.height /= 2;
    }
    @Override
    public Object clone(){
        GoldRingedStaff temp = null;
        try {
            temp = (GoldRingedStaff) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return temp;
        }
    }

}
