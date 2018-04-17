package com.sunny.search;

/**
 * 顺序查找
 * @author zhao.dy
 * @date 2018/4/17
 */
public class OrderSearch {

    public static int search(int num,int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
