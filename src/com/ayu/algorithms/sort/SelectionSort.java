package com.ayu.algorithms.sort;

/**
 * 选择排序算法实现
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {9,8,3,2,54,93,1,18,231,900,3};
        int len = arr.length;
        for (int i = 0; i<(len - 1); i++) {
            int pos = i;
            for (int j = i+1; j< len; j++) {
                pos = arr[j] < arr[pos] ? j : pos;
            }
            // 交换数值
            swap(arr, i , pos);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    private static void swap(int[] arr, int i, int pos) {
        if (i == pos) return;
        int temp = arr[i];
        arr[i] = arr[pos];
        arr[pos] = temp;
    }

}
