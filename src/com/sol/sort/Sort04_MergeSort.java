package com.sol.sort;

public class Sort04_MergeSort {

    /**
     * 04 归并排序
     * 时间复杂度：O（ N * log(N) ）
     * 左右都排好序，merge之后再排好序
     */

    public static void mergeSort(int[] arr){
        // 边界条件
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L == R){
            return;
        }
        int mid = L + ((R - L)>>1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    // 合并，通过一个新数组 --> 外排序
    private static void merge(int[] arr, int L, int mid, int R) {
        int[] res = new int[R - L + 1];
        // 指针
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= R ){
            res[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            res[i++] = arr[p1++];
        }
        while(p2 <= R){
            res[i++] = arr[p2++];
        }
        for(i = 0; i< res.length; i++){
            arr[L+i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,2,1,3,7,6};
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
