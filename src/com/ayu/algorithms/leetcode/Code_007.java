package com.ayu.algorithms.leetcode;

import java.math.BigInteger;

/**
 * 整数反转
 */
public class Code_007 {

    public static void main(String[] args) {
//        System.out.println(reverse(-321));
//        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {

        if (x == 0)
            return x;

        if (x < 10 && x > -10)
            return x;

        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
