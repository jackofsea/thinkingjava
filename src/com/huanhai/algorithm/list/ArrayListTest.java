package com.huanhai.algorithm.list;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 覃波
 * @version 1.0
 * @date 2021-02-23 23:11
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        //单链表测试
        SingleArrayListTest();
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("rest");
        Object[] strings = arrayList.toArray();
        System.out.println(Arrays.toString(strings));


    }

    public static void SingleArrayListTest() {
        SingleArrayList<String> stringSingleArrayList = new SingleArrayList<>(16);
        stringSingleArrayList.add("2323");
        stringSingleArrayList.add("你是");
        stringSingleArrayList.add("他是顾");
        System.out.println(stringSingleArrayList.size());
        System.out.println(stringSingleArrayList.get(2));
        System.out.println(stringSingleArrayList.isEmpty());
        stringSingleArrayList.printArray();
        //String[]data=stringSingleArrayList.toArray();
        stringSingleArrayList.remove(1);
        stringSingleArrayList.add("你是谁");
        System.out.println(stringSingleArrayList.get(1));
        System.out.println(stringSingleArrayList.size());
        stringSingleArrayList.remove(3);
        stringSingleArrayList.printArray();
        stringSingleArrayList.add("你是");
        stringSingleArrayList.add("你是2");
        stringSingleArrayList.printArray();
        System.out.println(stringSingleArrayList.indexOf("你是1"));




    }
}

class SingleArrayList<T> {
    private Object[] data;
    private int size;

    public SingleArrayList(int length) {
        data = new Object[length];
    }

    public SingleArrayList() {
        data = new Object[10];
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return (T) data[index];
    }

    /**
     * 添加
     *
     * @param object
     */
    public void add(T object) {
        data[size++] = object;
    }



    /**
     * 删除
     *
     * @param index
     */
    public void remove(int index) {
        if (index >= size || index < 0) {
            return;
        }
        //删除元素
        data[index] = null;
        for (; index < size - 1; index++) {
            data[index] = data[index + 1];
        }
        size--;
    }

    /**
     *  查找指定数据的下标
     * @param o
     * @return
     */
    public int indexOf(T o) {

        for (int i=0;i<size;i++){
          if(o.equals(data[i])){
              return i;
          }
        }
        return -1;
    }



    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    public T[] toArray() {
//
//        return (T[]) data;
//    }
    public void printArray() {
        System.out.print("[ ");
        for (int i=0;i<size;i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }

}
