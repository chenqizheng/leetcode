package com.chen.group.search.partition;

import com.chen.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), list);
        return list;

    }

    private void dfs(int start, String s, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (isPalindrome(temp)) {
                list.add(temp);
                dfs(i + 1, s, list, result);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String temp) {
        int left = 0;
        int right = temp.length() - 1;
        while (left < right) {
            if (temp.charAt(left) != temp.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = new PalindromePartitioning().partition("aab");
        Utils.print(result);
    }
}
