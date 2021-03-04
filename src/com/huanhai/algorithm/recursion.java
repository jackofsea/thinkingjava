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
        System.out.println(fibon(100));
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


}
