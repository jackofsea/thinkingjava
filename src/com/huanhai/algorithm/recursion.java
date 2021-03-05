package com.huanhai.algorithm;

/**
 *  递归算法
 *
 * @author loufeng
 * @version 1.0
 * @date 2021-03-04 11:33
 **/
public class recursion {

    public static void main(String[] args) {
        System.out.println(fibon(11));
        System.out.println(fibon(11,1,1));
        System.out.println(factorial(10));
        System.out.println(factorial(10,1));
    }

    /**
     * 递归求解斐波拉契数列， 1、1、2、3、5、8
     *
     * @param i
     * @return
     */
    public static int fibon(int i){
        if(i <= 2){
            return 1;
        }
        return fibon(i-1)+fibon(i-2);
    }


    /**
     * 递归求解斐波拉契数列， 1、1、2、3、5、8
     * 尾递归
     * @param i
     * @return
     */
    public static int fibon(int i,int pre,int res){
        if(i <= 2){
            return res;
        }
        return fibon(i-1,res,pre+res);
    }

    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n*factorial(n-1);
    }

    /**
     * 阶乘,尾递归
     *
     * @param n
     * @return
     */
    public static int factorial(int n,int res){
        if(n <= 1){
            return res;
        }
        return factorial(n-1,res*n);
    }



}
