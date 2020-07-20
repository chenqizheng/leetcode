package com.chen.group.search.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            dfs(lists, nums, new ArrayList<>(), 0, i);
        }
        return lists;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> select, int start, int n) {
        if (n == select.size()) {
            result.add(new ArrayList<>(select));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            select.add(nums[i]);
            dfs(result, nums, select, i + 1, n);
            select.remove(select.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new SubSets().subsets(new int[]{1, 2, 3});
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
