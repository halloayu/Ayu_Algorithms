package com.ayu.algorithms.leetcode;

import java.math.BigInteger;

/**
 * atoi
 */
public class Code_008 {

    public static void main(String[] args) {

        System.out.println(myAtoi("  0000000000012345678"));
    }

    public static int myAtoi(String s) {

        int index = 0; // 记录第一个整数位置

        s = s.trim();
        if (s.equals("")) return 0;
        if (s.length() == 1) {
            if (!"0123456789".contains(s)) {
                return 0;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char sub = s.charAt(i);

            // 数字
            if ((int) sub >= 48 && (int) sub <= 57) {
                index = i;
                break;
            }
        }

        if (index == 0) {
            if ((int) s.charAt(0) < 48 || (int) s.charAt(0) > 57) {
                return 0;
            }
        }

        if (index > 1 ) return 0;
        if (index > 0 && (s.charAt(0) != '-' && s.charAt(0) != '+') ) return 0;

        // 确定符号
        boolean isPositive = false;
        if (index > 0) {
            if (s.charAt(index - 1) == '-') {
                isPositive = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        String answer;
        // 截断
        int j = index;
        while (true) {
            if (j >= s.length()) {
                break;
            }
            if ((int) s.charAt(j) >= 48 && (int) s.charAt(j) <= 57) {
                j ++;
            } else {
                break;
            }
        }

        s = s.substring(index, j);

        if (s.charAt(0) == '0') {
            int x1 = 0;
            char x2 = s.charAt(x1);
            while (x2 == '0') {
                x1++;
                if (x1 >= s.length()) {
                    return 0;
                }
                x2 = s.charAt(x1);
            }
            s = s.substring(x1);
        }

        index = 0;
        while (true) {
            if (index >= s.length()) {
                break;
            }
            char sub = s.charAt(index);
            if ((int) sub >= 48 && (int) sub <= 57) {
                sb.append(sub);
            } else {
                break;
            }

            if (sb.length() > 10) {
                if (isPositive) {
                    sb = new StringBuilder("2147483648");
                } else {
                    sb = new StringBuilder("2147483647");
                }
                index = s.length();
            }

            if (sb.length() == 10) {
                if (isPositive) {
                    if (sb.toString().compareTo("2147483648") > 0) {
                        sb = new StringBuilder("2147483648");
                        index = s.length();
                    }
                } else {
                    if (sb.toString().compareTo("2147483647") > 0) {
                        sb = new StringBuilder("2147483647");
                        index = s.length();
                    }
                }
            }
            index++;
        }

        answer = sb.toString();
        if (isPositive) {
            answer = "-" + answer;
        }

        return Integer.parseInt(answer);
    }
}
