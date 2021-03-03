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
    public void add(E e) {
        if(isFull()){
            return;
        }
        //队尾已经达到,向前移动元素
        if(tail >= elements.length){
            int offer= head;
             for (int i=0;i<size;i++){
               elements[i]=elements[offer+i];
             }
             head=0;
             tail-=offer;
        }
        elements[tail++] = e;
        size++;

    }

    /**
     * 出队
     *
     * @return
     */
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = (E)elements[head++];
        elements[head-1] = null;
        size--;
        return e;
    }

    /**
     * 查看队头的元素
     */
    public E peek() {
        return tail == elements.length? null:(E) elements[head];
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
        arrayQueue.add("nishi");
        arrayQueue.add("ni43shi");
        arrayQueue.add("ni34shi");
        arrayQueue.poll();
        arrayQueue.add("ni43shi");
        arrayQueue.add("nis43hi");
        arrayQueue.add("nis43hi");
        arrayQueue.add("nis43hi");
        System.out.println(arrayQueue.isEmpty() + " "+arrayQueue.isFull());
        arrayQueue.poll();
        System.out.println(arrayQueue.isEmpty() + " "+arrayQueue.isFull());
        arrayQueue.poll();
        arrayQueue.poll();
        arrayQueue.poll();
        arrayQueue.poll();
        arrayQueue.poll();
        System.out.println(arrayQueue.isEmpty() + " "+arrayQueue.isFull());

        System.out.println(arrayQueue.peek());
    }


}
