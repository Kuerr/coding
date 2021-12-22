package com.sol.sort;

import java.util.Arrays;

import static com.sol.tool.Tool01_ABCompare.Tool01_JavaBase.swap;

public class Sort06_HeapSort {
    /**
     * 堆排序
     * heapInsert
     * heapify
     */
    public static void heapSort(int[] arr){
        // bound
        if(arr == null || arr.length < 2){
            return;
        }
        // 构造大根堆,逐个插入
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        // 排序 --> 条件：堆值没有
        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0 , --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        // bound
        while(left < size){
            // 1. 找到两孩子最大的值
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left+1 : left;
            // 2. 和父节点进行比较
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,  largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,8,6,7,4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
