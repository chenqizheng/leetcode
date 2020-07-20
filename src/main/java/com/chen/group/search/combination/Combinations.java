package com.chen.group.search.combination;

import java.util.ArrayList;
import java.util.List;

/***
 https://leetcode.com/problems/combinations/
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> select, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(select));
        } else {
            for (int i = n; i > 0; i--) {
                select.add(i);
                dfs(result, select, i - 1, k - 1);
                select.remove(select.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Combinations().combine(4, 2);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
