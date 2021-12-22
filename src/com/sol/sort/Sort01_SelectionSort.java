package com.sol.sort;

public class Sort01_SelectionSort {

    /**
     * 01 选择排序
     * 时间复杂度：O（N^2）
     * 扫描一遍,找到最小的
     */

    public static void main(String[] args) {
        int[] arr = {4,5,2,1,3,7,6};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

     public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }
        // 选择排序
        for(int i = 0; i < arr.length; ++i){
            int minIndex = i;
            for(int j = i; j < arr.length; ++j){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }
}
