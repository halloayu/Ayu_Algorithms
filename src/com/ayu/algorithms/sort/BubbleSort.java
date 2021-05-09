package com.ayu.algorithms.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 2, 54, 93, 1, 18, 231, 900, 3};
        sort(arr);
        printArray(arr);
    }

    static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) { // 10 - 1
            for (int j = 0; j < i; j++) { // 0-9 0-8 ... 0
                if (arr[j] > arr[j + 1]) { // 大的往后挪
                    swap(arr, j, j + 1);
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
