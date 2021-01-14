package com.huanhai.thinkjava.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Map子类的的总结
 * 1.HashMap
 *   1)HashMap是键值对的集合，具体结构是数组+链表（1.8是单链表/红黑树，1.7是单链表）;
 *   2)Map<String,String> m=new HashMap<>()这种形式创建对象，后面的“<>”没有类型是由于JDK1.8的类型推导作用;
 *   3)多线程put数据，可能卡在java.util.HashMap$TreeNode.balanceInsertion(HashMap.java:2229)造成假的死循环,
 *    也可能出现Node节点转换为TreeNode结点异常，数据发生覆盖;
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-01-12 9:48
 **/
public class MapTest {
    public static void main(String[] args) {
        testHashMapSafe();

    }

    /**
     * 可能卡在java.util.HashMap$TreeNode.balanceInsertion(HashMap.java:2229)
     * 可能Node节点转换为TreeNode结点异常
     *
     */
    public static void testHashMapSafe(){
        Map<Integer,Integer> m=new HashMap<>();
        Random random=new Random();
        for (int i=0;i<10;i++){
            new Thread(()->{
                int j=0;
                while (j<10000){
                    m.put(random.nextInt(),random.nextInt());
                    j++;
                }
                System.out.println(Thread.currentThread().getName()+"完成填充数据");
            }).start();
        }
    }

}
