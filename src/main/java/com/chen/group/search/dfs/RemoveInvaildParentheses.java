package com.chen.group.search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvaildParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            }
            if (l == 0) {
                r += (c == ')' ? 1 : 0);
            } else {
                l -= (c == ')' ? 1 : 0);
            }
        }
        List<String> result = new ArrayList<>();
        dfs(s, 0, l, r, result);
        return result;
    }

    private void dfs(String s, int start, int l, int r, List<String> result) {
        if (l == 0 && r == 0 && isVaild(s)) {
            result.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (l > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i+1), i, l - 1, r, result);
            }
            if (r > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i+1), i, l, r - 1, result);
            }
        }
    }

    private boolean isVaild(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        List<String> result = new RemoveInvaildParentheses().removeInvalidParentheses("()())()");
        for (String s : result
        ) {
            System.out.println(s);
        }

    }
}
