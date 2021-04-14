package com.ayu.algorithms;

import java.util.*;

public class LeetCode_001 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = LeetCode_001.threeSum2(nums);
        System.out.println(lists);
    }

    /**
     * 两数之和
     */

    // 暴力枚举 时间复杂度O(n*n) 空间复杂度O(1)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 以时间换空间
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>(len - 1);
        for (int i = 0; i < len; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 三数之和
     */

    // 暴力遍历，效率很差
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int x = j + 1; x < len; ++x) {
                    if (nums[i] + nums[j] + nums[x] == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[x]));
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }

    // 以时间换空间
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int He, min;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        if (nums.length < 3) return new ArrayList<List<Integer>>(set);
        min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的值
            if (i != 0)
                while (nums[i] == nums[i - 1] && i < nums.length - 2)
                    i++;
            for (int j = i + 1, x = nums.length - 1; j < x; ) {
                He = nums[i] + nums[j] + nums[x];
                if (He < 0) {
                    if ((-He) < Math.abs(min)) min = He;
                    j++;
                } else if (He > 0) {
                    if (He < Math.abs(min)) min = He;
                    x--;
                } else {
                    set.add(Arrays.asList(nums[i], nums[j], nums[x]));
                    x--;
                }
            }
        }
        return new ArrayList<List<Integer>>(set);

    }

}
