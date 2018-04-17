package com.sunny.sort;

/**
 * 冒泡排序
 * @author zhao.dy
 * @date 2018/4/17
 */
public class BubbleSort {

    public static void sort(int[] arr){
        //第几趟
        for (int i = 0; i < arr.length-1; i++) {
            //每一趟将最小的移到前边去
            for (int j = arr.length - 1; j > i; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
