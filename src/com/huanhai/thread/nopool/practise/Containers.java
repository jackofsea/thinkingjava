package com.huanhai.thread.nopool.practise;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

//系统自带的观察者模式
public class Containers {
    public static void main(String[] args) {
        Container subuject=new Container();
        Dectect dectect=new Dectect();
        subuject.addObserver(dectect);
        new Thread(()->{
            for(int i=0;i<32;i++){
                subuject.add("122");
            }

        }).start();

    }

}

class Container extends Observable{
    private List<String>  list=new ArrayList<>(32);
    public void add(String s){
        list.add(s);
        setChanged();
        notifyObservers();
    }

}




class Dectect implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("放到五个了" + arg);
    }
}
