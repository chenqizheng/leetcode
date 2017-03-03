package com.chen.leetcode;

import java.util.HashMap;

/**
 * Created by Chen on 2017/3/3.
 * questtion:
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int result = 0;
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (char c : s.toCharArray()
                ) {
            if (hash.containsKey(c + "")) {
                hash.put(c + "", hash.get(c + "") + 1);
            } else {
                hash.put(c + "", 1);
            }
        }
        for (String c : hash.keySet()
                ) {
            Integer count = hash.get(c);
            if (count != null)
                if (count % 2 != 0) {
                    result = result + count - 1;
                } else {
                    result = result + count;
                }
        }
        if (result == s.length()) {
            return result;
        }
        return result % 2 != 0 ? result : result + 1;
    }

    public int longestPalindrome1(String s) {
        int[] array = new int[54];
        int result = 0;
        int split = 'a' - 'Z' + 1;
        for (char c : s.toCharArray()) {
            if (c - 'A' >= 0 && c - 'z' <= 0) {
                if (c - 'a' >= 0) {
                    array[c - 'A' - split]++;
                } else {
                    array[c - 'A']++;

                }
            }
        }
        for (int i : array) {
            result += i / 2 * 2;
        }
        return result == s.length() ? result : result + 1;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome1("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }
}
