package com.huanhai.algorithm.stack;

/**
 * 栈，基于链表实现
 *
 * @author luofeng
 * @version 1.0
 * @date 2021-02-26 11:48
 **/
public class LinkStack<T> {

    /**
     * 栈顶
     */
    private Node top;

    /**
     * 栈元素个数
     */
    private int size;

    /**
     *  入栈
     * @param o 元素，压入栈顶
     */
    public void push(T o) {
        Node node = new Node(o);
        node.next=top;
        top=node;
        size++;
    }

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    public T peek() {
        return  top == null ? null: top.object;
    }

    /**
     * 出栈
     *
     * @return 栈顶元素，并移除
     */
    public T pop() {
        if(isEmpty()){
          return null;
        }
        //取出栈顶元素
       T t=top.object;
       top= top.next;
       size--;
       return t;
    }

    /**
     * 返回栈元素；
     *
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断是否为栈空
     *
     * @return
     */
    public boolean isEmpty(){
        return top == null;
    }

    class Node {
        private T object;
        private Node next;

        public Node(T o) {
            object = o;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkStack<String> linkStack = new LinkStack<>();
        linkStack.push("212");
        linkStack.push("23111");
        linkStack.push("傻逼");
        linkStack.push("二逼");
        System.out.println(linkStack.pop());
        System.out.println(linkStack.peek());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        linkStack.push("傻逼221");
        System.out.println(linkStack.pop());
        System.out.println(linkStack.peek());
        System.out.println(linkStack.size());
    }
}
