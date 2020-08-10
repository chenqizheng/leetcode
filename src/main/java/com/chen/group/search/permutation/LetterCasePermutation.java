package com.chen.group.search.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        dfs(S, 0, "", result);
        return result;
    }

    private void dfs(String s, int start, String current, List<String> result) {
        if (current.length() == s.length()) {
            result.add(current);
            return;
        } else {
            for (int i = start; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(current);
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'z') {
                    char backup = s.charAt(i);
                    dfs(s, i + 1, current + Character.toUpperCase(backup), result);
                    dfs(s, i + 1, current + Character.toLowerCase(backup), result);
                } else {
                    dfs(s, i + 1, current + s.charAt(i), result);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = new LetterCasePermutation().letterCasePermutation("a1b2");
        for (String s : result
                ) {
            System.out.println(s);
        }
    }
}
