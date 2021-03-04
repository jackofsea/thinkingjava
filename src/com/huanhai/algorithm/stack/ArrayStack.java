package com.huanhai.algorithm.stack;

/**
 * 栈，基于数组实现
 *
 * @author loufeng
 * @version 1.0
 * @date 2021-02-26 11:48
 **/
public class ArrayStack<T> {

    /**
     * 数据
     */
    private Object[] objects;

    /**
     * 元素个数
     */
    private int size;

    public ArrayStack() {
        objects = new Object[16];
    }

    public ArrayStack(int deep) {
        objects = new Object[deep];
    }

    /**
     *  入栈
     * @param o
     */
    public void push(T o) {
        objects[size++] = o;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        if(isEmpty()){
            return null;
        }
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
        if(isEmpty()){
            return null;
        }
        Object o = objects[size - 1];
        return (T) o;
    }

    /**
     * 判断栈空
     *
     * @return
     */
    /**
     * 判空
     *
     * @return true or false
     */
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
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

}

