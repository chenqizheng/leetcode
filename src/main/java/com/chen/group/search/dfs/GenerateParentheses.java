package com.chen.group.search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, "", result,n * 2);
        return result;
    }

    private void dfs(int l, int r, String current, List<String> result,int max) {
        if (l + r == max) {
            result.add(current);
            return;
        }
        if (2 * l < max) {
            dfs(l + 1, r, current + "(", result,max);
        }
        if (l > r) {
            dfs(l, r + 1, current + ")", result,max);
        }
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis(3);
        for (String temp : result
        ) {
            System.out.println(temp);
        }
    }
}
