package com.huanhai.java300;

import java.util.Arrays;

/**
 * 杨辉三角打印
 *
 * @author 覃波
 * @version 1.0
 * @date 2020/7/27 10:35
 **/
public class PascalTriangle {


    public static void main(String[] args) {
        print(2);
    }

    //打印杨辉三角
    public static void print(int n) {

        if (n<=0){
            return;
        }

        if(n==1){
            System.out.println(" 1 ");
        }else if (n ==2){
            System.out.println(" 1 ");
            System.out.println("1  1");
        }else {
            int length = 2 * n - 1;
            int[] upArray = new int[length];
            int[] downArray = new int[length];
            upArray[n-1]=1;
            downArray[n-2]=1;
            downArray[n]=1;
            System.out.println(Arrays.toString(upArray));
            System.out.println(Arrays.toString(downArray));
            for (int i=3;i<=n;i++){
                if(i%2!=0){
                   for (int j=0;j<i;j++){
                       upArray[(i+1)/2]=downArray[i/2-1]+downArray[i/2+1];
                   }
                }else {

                }
            }
        }

    }

}


