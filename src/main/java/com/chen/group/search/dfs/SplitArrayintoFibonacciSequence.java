package com.chen.group.search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 */
public class SplitArrayintoFibonacciSequence {

    /***
     * Input: "123456579" Output: [123,456,579]
     * 
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(0, S, result);
        return result;
    }

    private boolean dfs(int pos, String s, List<Integer> result) {
        if (pos == s.length() && result.size() >= 3) {
            return true;
        }
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(pos) == '0' && i > pos) {
                break;
            }
            long num = Long.parseLong(s.substring(pos, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = result.size();
            if (size >= 2 && num > result.get(size - 2) + result.get(size - 1)) {
                break;
            }
            if (size <= 1 || num == result.get(size - 2) + result.get(size - 1)) {
                result.add((int) num);
                if (dfs(i + 1, s, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> list = new SplitArrayintoFibonacciSequence().splitIntoFibonacci("123456579");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
