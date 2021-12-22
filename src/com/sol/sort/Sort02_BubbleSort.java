package com.sol.sort;

public class Sort02_BubbleSort {

    /**
     * 02 冒泡排序
     * 时间复杂度：O（N^2）
     * 若前者大于后面的数，就交换
     */

    public static void main(String[] args) {
        int[] arr = {4,5,2,1,3,7,6};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }
        for(int i = arr.length - 1; i >= 0; --i){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]) {
                    swap(arr, j+1, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
