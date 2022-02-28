package com.ayu.algorithms.leetcode;

/**
 * 水桶问题
 */
public class Code_011 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length -1;
        int max = 0;
        while (i < j) {
            int y = Math.min(height[i], height[j]);
            max = Math.max(max, y * (j -i));

            if (height[i] < height[j])
                i ++;
            else
                j--;
        }

        return max;
    }

}
