package com.huanhai.test;

/**
 * @author 覃波
 * @version 1.0
 * @date 2021-02-19 11:15
 **/
public  class Teacher {

    private  String baseName="Teacher";

    Teacher(){
        call();
    }
    public void call(){
        System.out.println(baseName);
    }
    interface condition{
        void getName();
    }
    public final void say(){
        System.out.println("哈喽Teacher");
    }

    static class inner extends Teacher{
        private static    String baseName="inner";
        private     String baseName2="inner";

        public void call(){
            System.out.println(baseName);
            System.out.println(baseName2);
        }

    }

    public static void main(String[] args) {
        Teacher t=new inner();
    }
}
