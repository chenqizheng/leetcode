package com.chen.group.search.combination;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> select, int start, int k, int n) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(select));
            return;
        }
        if (k <= 0) {
            return;
        }
        if (start > n) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            select.add(i);
            dfs(result, select, i + 1, k - 1, n - i);
            select.remove(select.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSumIII().combinationSum3(3, 7);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
