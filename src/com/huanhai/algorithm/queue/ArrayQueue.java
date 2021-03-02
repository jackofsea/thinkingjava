package com.huanhai.algorithm.queue;

/**
 * 队列，FIFO先进先出，下面的demo基于数组实现队列
 * @param <E>
 */
public class ArrayQueue<E> {
    /**
     * 数据
     */
    private Object[] elements;
    /**
     * 实际数据个数
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


    public ArrayQueue() {
        elements = new Object[16];
    }

    public ArrayQueue(int length) {
        elements = new Object[length];
    }

    /**
     * 入队
     * @param e
     */
    public void push(E e) {
        if(isFull()){
            return;
        }
        elements[tail++] = e;
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E e = (E)elements[head++];
        elements[head-1] = null;
        size--;
        return e;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail - head) == elements.length;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue=new ArrayQueue<>(5);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.push("nishi");
        arrayQueue.push("ni43shi");
        arrayQueue.push("ni34shi");
        arrayQueue.push("ni43shi");
        arrayQueue.push("nis43hi");
        System.out.println(arrayQueue.isEmpty() + " "+arrayQueue.isFull());
        arrayQueue.pop();
        System.out.println(arrayQueue.isEmpty() + " "+arrayQueue.isFull());
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.pop();
        arrayQueue.pop();
        System.out.println(arrayQueue.isEmpty() + " "+arrayQueue.isFull());
    }


}
