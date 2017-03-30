package com.chen.leetcode;

/**
 * Created by Chen on 2017/3/30.
 */
public class NumberOfWord {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
