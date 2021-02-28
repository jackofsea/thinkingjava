package com.huanhai.algorithm.stack;

/**
 * 链表实现栈
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-02-26 11:48
 **/
public class LinkStack<T> {
    private Node head;
    private Node tail;

    public void push(T o) {
        Node node = new Node(o);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public T peek() {
        return (T) tail.object;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        if (head == tail) {
            head = null;
            tail = null;
        }
        Node node = tail;
        Node pre = null;
        Node tmp = head;
        while (tmp != tail) {
            pre = tmp;
            tmp = tmp.next;
        }
        tail = pre;
        return node.object;
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
    }
}
