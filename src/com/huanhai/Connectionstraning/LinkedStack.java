package com.huanhai.Connectionstraning;

/**
 * @Description 利用内部类，泛型实现栈结构
 * @Author boqin
 * @Date 2019/5/7 22:45
 * @Version 1.0
 **/
public class LinkedStack<T> {
    private static class Node<T>{
        T item;
        Node<T> next;
        Node(){ item=null;next=null;}
        Node(T item,Node<T> next){
            this.item=item;
            this.next=next;
        }
        boolean end(){
            return item==null && next==null;
        }
    }
    private Node<T> top=new Node();
    public void push(T item){
        top=new Node(item,top);
    }
    public T pop(){
        T result=top.item;
        if (!top.end()){
            top=top.next;
        }
        return result;
    }

    public static void main(String[] args) {
       LinkedStack<String> lss=new LinkedStack<>();
       for (String s: "Phasers on stun!".split(" ")){
           lss.push(s);
       }
       String s1;
       while ((s1=lss.pop())!=null){
           System.out.println(s1);
       }
    }
}
