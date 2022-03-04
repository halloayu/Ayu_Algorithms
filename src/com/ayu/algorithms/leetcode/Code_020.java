package com.ayu.algorithms.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Code_020 {

    public static void main(String[] args) {
        System.out.println(isValid("({") + "");
    }

    public static boolean isValid(String s) {

        int len = s.length();
        // 不是成对，必为false
        if (len % 2 != 0) {
            return false;
        }

        HashMap map = new HashMap() {{
            put( '}','{');
            put(']','[');
            put( ')','(');
        }};
        

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

}
