package com.huanhai.test;

public interface IAnimal {
    default String say(){
        return "动物叫";
    }
    default String eat(){
        return "动物吃";
    }
    void weight();
    interface test{
       void test();
    }
    class inner implements test{
        private int s=2;

        @Override
        public void test() {
            System.out.println("接口内部类");
        }
    }
}
