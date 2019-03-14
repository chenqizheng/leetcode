package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {

    public static void main(String[] args) {
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] map1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] map2 = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                map2[s2.charAt(j) - 'a']++;
            }
            if (match(map1, map2)) {
                return true;
            }

        }

        return false;
    }

    public boolean match(int[] map1, int[] map2) {
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] == map2[2]) {
                return true;
            }
        }
        return false;
    }

}
