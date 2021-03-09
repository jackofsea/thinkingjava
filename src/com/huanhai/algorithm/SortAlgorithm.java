package com.huanhai.algorithm;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author luofeng
 * @version 1.0
 * @date 2021-03-09 15:36
 **/
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr1 = new int[]{88, 3, 6, 5, 101, 2, 9, 89, 91, 1};
        BubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[]{88, 3, 6, 5, 101, 2, 9, 89, 91, 1};
        StraightSort(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    /**
     * 冒泡排序
     *
     * @param data
     */
    public static void BubbleSort(int[] data) {
        int count = data.length - 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
//                    data[j]= data[j]^data[j+1];
//                    data[j+1]= data[j]^data[j+1];
//                    data[j]=data[j]^ data[j+1];
                }
            }
        }

    }

    /**
     * 插入排序
     *
     * @param data
     */
    public static void StraightSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmpdata = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (tmpdata < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = tmpdata;
        }

    }

}
