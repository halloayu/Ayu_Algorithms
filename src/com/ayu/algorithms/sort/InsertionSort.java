package com.ayu.algorithms.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 2, 54, 93, 1, 18, 231, 900, 3};
        sort(arr);
        printArray(arr);
    }

    static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // 0-9
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) { // 小的往前挪
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int pos) {
        int temp = arr[i];
        arr[i] = arr[pos];
        arr[pos] = temp;
    }

    static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
