package com.huanhai.test;

import java.lang.reflect.Field;

/**
 * @author 覃波
 * @version 1.0
 * @date 2020/7/7 16:43
 **/
public class Animal implements IAnimal {
    private int i=3;
    public Animal(int s){
        System.out.println(i);
        i=s;
        System.out.println(i);

    }
    @Override
    public String eat(){
        return "动物吃屎";
    }
    @Override
    public void weight() {
        System.out.println("20斤");
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Animal animal=new Animal(6);
        int[] a=new int[10];
        System.out.println(animal.eat());
        animal.weight();
        Class<?> animalClass=Animal.class;
        Field field =animalClass.getDeclaredField("i");
        field.setAccessible(true);
        System.out.println(field.get(animal));
        System.out.println(4*0.1);
        System.out.println(3*0.2);
        System.out.println(3*0.3);
        System.out.println(0.3);
        System.out.println(a[1]);

    }
}
