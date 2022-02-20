package com.ayu.algorithms.leetcode;

/**
 * 最长回文字符串
 */
public class Code_005 {

    public static void main(String[] args) {
        System.out.printf(longestPalindrome("48900921"));
    }

    /**
     * 时间复杂度 O(n^3) 空间复杂度O(1)
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // 枚举所有长度严格大于 1 的字串 charArray[i...j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static boolean validPalindromic(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


}
