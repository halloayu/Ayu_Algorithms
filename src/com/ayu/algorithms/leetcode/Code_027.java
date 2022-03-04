package com.ayu.algorithms.leetcode;

import java.util.ArrayList;

/**
 * 删除有序数组
 */
public class Code_027 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        ArrayList<Integer> newNums = new ArrayList<>();

        int len = nums.length;
        int x = nums[0];
        newNums.add(x);
        for (int i = 1; i< len; i++) {
            if (x != nums[i]) {
                x = nums[i];
                newNums.add(x);
            }
        }
        int[] nums2 = new int[newNums.size()];
        for (int i=0; i<newNums.size() ;i++) {
            nums2[i] = newNums.get(i);
        }
        nums = nums2;
        return nums.length;
    }

}
