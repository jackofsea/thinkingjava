package com.huanhai.Connectionstraning;

/**
 * @Description ToDo
 * @Author boqin
 * @Date 2019/4/23 23:09
 * @Version 1.0
 **/
public class practices1 {
    public static void main(String[] args) {
        Holder3<Animal> holder3=new Holder3();
        holder3.set(new Animal("猫"));
        holder3.set(new Tiger("老虎","嗷嗷"));
        Holder4<Animal> holder4=new Holder4(new Animal[5]);
        holder4.set(new Animal("动物1"),0);
        holder4.set(new Tiger("动物1","嗷嗷啊"),1);
        holder4.set(new Animal("动物3"),2);
        System.out.println(holder4.get(2));
    }
}
class Holder3<T>{
    private T a;
    public Holder3(){}
    public Holder3(T a){
        this.a=a;
    }
    public void set(T a){
        this.a=a;
    }
    public T get(){
        return this.a;
    }
}
class Holder4<T>{
    private T[] data;
    public Holder4(){}
    public Holder4(T[] a){
        this.data=a;
    }
    public void set(T a,int i){
        data[i]=a;
    }
    public T get(int i){
        return data[i];
    }
}
class Animal{
    private String name;
    public Animal(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Tiger extends Animal{
    private String sound;
    public Tiger(String name,String sound){
      super(name);
      this.sound=sound;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "sound='" + sound + '\'' +
                '}';
    }
}