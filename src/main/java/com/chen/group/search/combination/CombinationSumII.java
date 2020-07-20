package com.chen.group.search.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, new ArrayList<Integer>(), target);
        return result;
    }

    public void combinationSum2(int[] candidates, int start, ArrayList<Integer> select, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(select));
        }
        if (target < 0) return;
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            select.add(candidates[i]);
            combinationSum2(candidates, i + 1, select, target - candidates[i]);
            select.remove(select.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
