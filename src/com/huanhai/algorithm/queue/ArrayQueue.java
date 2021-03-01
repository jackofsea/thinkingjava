package com.huanhai.algorithm.queue;

public class ArrayQueue<E> {
    /**
     *  数据
     */
    private Object[] elements;
    /**
     *    实际数据个数
     */
    private int size;
    /**
     * 队头
     */
    private int head;

    /**
     * 队尾
     */
    private int tail;


    public ArrayQueue(){
        elements=new Object[16];
    }
    public ArrayQueue(int length){
        elements=new Object[length];
    }

    public void push(E e){
        elements[size--]=e;
        size++;
        tail++;
    }

    public E pop(E e){
        if(isEmpty()){

        }
        elements[size--]=e;
        elements[size]=null;
        size++;
        head++;
        return  e;
    }

    public boolean isEmpty(){
        return head == tail;
    }


}
