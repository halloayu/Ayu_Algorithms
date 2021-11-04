package com.ayu.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code_003 {

    public static void main(String[] args) {

        String s = "21890df0her0ruqfchwe8hrgqkex";

        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            // 取最大的
            ans = Math.max(ans, end - start + 1);

            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

}
