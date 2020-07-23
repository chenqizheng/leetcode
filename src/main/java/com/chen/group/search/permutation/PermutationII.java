package com.chen.group.search.permutation;

import com.chen.group.search.combination.CombinationSumIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, new ArrayList<Integer>(), nums, used);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> select, int[] nums, boolean[] used) {
        if (select.size() == nums.length) {
            result.add(new ArrayList<Integer>(select));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            select.add(nums[i]);
            dfs(result, select, nums, used);
            select.remove(select.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new PermutationII().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
