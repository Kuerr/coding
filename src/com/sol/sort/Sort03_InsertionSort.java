package com.sol.sort;

public class Sort03_InsertionSort {

    /**
     * 03 插入排序，和前面一个数比较
     * 时间复杂度：O（N^2）
     * 触发结束条件：比较相差+前面没有数
     */
    public static void main(String[] args) {
        int[] arr = {4,5,2,1,3,7,6};
        InsertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void InsertionSort(int[] arr){
        // 边界条件的判定
        if(arr == null ||arr.length < 2){
            return ;
        }
        // 从1开始
        // j >= 0 && arr[j] > arr[j+1] ---> 顺序不能变，因为会涉及 这个概念忘了
        for(int i = 1; i < arr.length; ++i){
            // 01 i-1
            /*for(int j = i - 1 ;  j >= 0 && arr[j] > arr[j+1] ; j--){
                swap(arr, j+1, j);
            }*/
            // 02 i+1
            for(int j = i ;  j > 0 && arr[j] < arr[j-1] ; j--){
                swap(arr, j-1, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
