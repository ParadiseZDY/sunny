package com.sunny.sort;

/**
 * 选择排序
 * @author zhao.dy
 * @date 2018/4/17
 */
public class SelectSort {

    /**
     * 获取出最小的数，放在已排好序的末尾
     * @param arr
     */
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]){
                    k = j;
                }
            }
            if (i != k){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
