package com.chen.leetcode;

import java.util.HashMap;

/***
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    private static String minWindow(String s1, String s2) {
        int left = 0;
        int right = 0;
        int vaild = 0;
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : s2.toCharArray()) {
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) + 1);
            } else {
                needs.put(c, 1);
            }
        }
        int start = 0;
        int length = Integer.MAX_VALUE;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                if (windows.containsKey(c)) {
                    windows.put(c, windows.get(c) + 1);
                } else {
                    windows.put(c, 1);
                }
                if (windows.get(c) == needs.get(c)) {
                    vaild++;
                }
            }
            while (vaild == needs.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char d = s1.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (needs.get(d) == windows.get(d)) {
                        vaild--;
                    }
                    if (windows.get(d) > 0) {
                        windows.put(d, windows.get(d) - 1);
                    }
                }
            }
        }
        if (length == Integer.MAX_VALUE) {
            return "";
        } else {
            return s1.substring(start,start + length);
        }
    }

    public static void main(String[] args) {

        System.out.println(minWindow("EBBANCF", "ABC"));
    }
}
