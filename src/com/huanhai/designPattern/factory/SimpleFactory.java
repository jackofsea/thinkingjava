package com.huanhai.designPattern.factory;

/**
 * @version 1.0
 * @Description: 简单工厂
 * @Author: 覃波
 * @Date: 2019/8/28
 */
public class SimpleFactory {
    public static Food getFood(String name){
       if("牛奶".equals(name)){
           return new Milk();
       }else if("面包".equals(name)){
           return new Bread();
       }
       return new Food(){
           @Override
           public void show() {
               System.out.println("匿名内部类，什么都没有");
           }
       };

    }
    public static void main(String[] args) {
        getFood("面包").show();
    }

}


class Milk implements Food{
     private String name;
    @Override
    public void show() {
        System.out.println("这是牛奶");
    }

}
class Bread implements Food{
    private String name;
    @Override
    public void show() {
        System.out.println("这是面包");
    }

}

