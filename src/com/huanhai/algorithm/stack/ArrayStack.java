package com.huanhai.algorithm.stack;

/**
 * 数组实现栈
 *
 * @author 覃波
 * @version 1.0
 * @date 2021-02-26 11:48
 **/
public class ArrayStack<T> {

    private Object[] objects;
    private int size;

    public ArrayStack() {
        objects = new Object[16];
    }

    public ArrayStack(int deep) {
        objects = new Object[deep];
    }

    public void push(T o) {
        objects[size++] = o;
    }

    public T pop() {
        Object o = objects[--size];
        objects[size] = null;
        return (T) o;
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public T peek() {
        Object o = objects[size - 1];
        return (T) o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("n你是");
        stack.push("n你2是");
        stack.push("n你是3");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty() + " " + stack.size);
    }

}

