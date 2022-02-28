package com.ayu.algorithms.leetcode;

import java.util.ArrayList;

/**
 * Z字行 变换
 */
public class Code_006 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        // 小于numRows
        int len = s.length();
        if (len <= numRows) {
            return s;
        }

        if (numRows == 1) {
            return s;
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            arrayList.add("");
        }

        int xx = 2 * numRows -2;
        for (int i = 0; i < len; i++) {
            char sub = s.charAt(i);
            int yy = (i + 1) % xx;
            if (yy == 0) {
                String s1 = arrayList.get(1) + sub;
                arrayList.set(1, s1);
                continue;
            }
            if ( yy <= numRows) {
                String s1 = arrayList.get(yy - 1) + sub;
                arrayList.set(yy -1, s1);
            } else {
                int yyy = 2 * numRows -yy;
                String s1 = arrayList.get(yyy - 1) + sub;
                arrayList.set(yyy -1, s1);
            }
        }

        String newString = "";
        for (String s2 : arrayList) {
            newString = newString + s2;
        }

        return newString;

    }

}
