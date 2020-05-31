package com.chen.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int vaild = 0;
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : p.toCharArray()) {
            needs.put(c, 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, 1);
                if(windows.get(c) ==)
                vaild++;
            }
        }
        return list;
    }
}
