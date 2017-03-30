package com.chen.leetcode;

import java.util.*;

/**
 * Created by Chen on 2017/3/30.
 * herf: https://leetcode.com/problems/isomorphic-strings
 */
public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> hashmap = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            char q = t.charAt(i);
            if (hashmap.containsKey(p)) {
                if (hashmap.get(p).equals(q)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!hashmap.containsValue(q))
                    hashmap.put(p, q);
                else
                    return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {

    }
}
