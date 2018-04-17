package com.sunny.search;

/**
 * 二分查找法,数组必须是排好序的
 * @author zhao.dy
 * @date 2018/4/17
 */
public class BinarySearch {

    public static int search(int num,int[] arr){
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end){
            int middle = (begin + end) / 2;
            if (num == arr[middle]){
                return middle;
            }else if(num < arr[middle]){
                end = middle - 1;
            }else if(num > arr[middle]){
                begin = middle + 1;
            }
        }
        return -1;
    }
}
