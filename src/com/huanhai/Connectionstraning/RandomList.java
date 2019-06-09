package com.huanhai.Connectionstraning;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Description ToDo
 * @Author boqin
 * @Date 2019/5/7 23:09
 * @Version 1.0
 **/
public class RandomList<T> {
    private ArrayList<T> storage=new ArrayList<>();
    private Random rand=new Random(47);
    public void add(T item){storage.add(item);}
    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs=new RandomList<>();
        for(String s:("The quick brown fox jumpwd over "+"the lazy brown dog").split(" ")){
            rs.add(s);
        }
        for (int i=0;i<11;i++){
            System.out.println(rs.select()+" ");
        }
    }
}
