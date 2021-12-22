package com.sol.sort;

import static com.sol.tool.Tool01_ABCompare.Tool01_JavaBase.swap;

/**
 * 快速排序
 * 以随机一个数作为标准，基础问题为荷兰国旗问题
 */
public class Sort05_QuickSort {

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

     private static void quickSort(int[] arr, int left, int right) {
        if(left < right){
            swap(arr, left + (int) (Math.random()*(right - left + 1)), right);
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }

    }

    /**
     * arr[l..r]
     */
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        // 边界条件：左右指针不等
//        while(L < more){
//            if(arr[L] < arr[R]){
//                swap(arr, ++less, );
//            }
//        }
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        // 后面有个交换，将之前的数和后面的交换
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    public static void main(String[] args) {
        int[] arr = {4,5,2,1,3,7,6};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
