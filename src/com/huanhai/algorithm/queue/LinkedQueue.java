package com.huanhai.algorithm.queue;

/**
 *
 * 队列，FIFO先进先出，下面的demo基于单链表实现队列
 *
 * @author luofeng
 * @version 1.0
 *
 * @date 2021-03-03 23:17
 **/
public class LinkedQueue<E> {

    /**
     * 队头
     */
    private Node<E> head;

    /**
     * 队尾
     */
    private Node<E> tail;

    /**
     * 队列元素个数
     */
    private int size;

    public LinkedQueue(){

    }

    /**
     * 入队
     *
     * fix
     * @param e
     */
    public void add(E e){
      Node<E> node=new Node<>(e);
      Node<E> f=tail;
      tail=node;
      if(f==null){
          head=node;
      }else {
         f.next=node;
      }
      size++;
    }

    /**
     * 出队
     * fix
     * @return 元素
     */
    public E poll(){
     if(isEmpty()){
         return null;
     }
     E e=head.e;
     head=head.next;
     size--;
     return e;
    }

    /**
     * 查看队头的元素
     */
    public E peek() {
        return head == null?null:head.e;
    }

    /**
     * 判断队列是否为空
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return head == null;
    }


    /**
     * 返回队列元素个数
     *
     * @return 元素个数
     */
    public int size() {
        return size;
    }

    class Node<E>{
        private E e;
        private Node<E> next;
        public Node(E e){
            this.e=e;
        }

        public Node<?> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue=new LinkedQueue<>();
        linkedQueue.add("2323");
        linkedQueue.add("232323");
        linkedQueue.add("232233你");

        System.out.println( linkedQueue.poll());

        linkedQueue.add("张三");
        System.out.println(linkedQueue);

    }
}
