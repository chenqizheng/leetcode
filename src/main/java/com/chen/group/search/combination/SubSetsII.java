package com.chen.group.search.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubSetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> select, int[] nums, int start) {
        result.add(new ArrayList<>(select));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            select.add(nums[i]);
            dfs(result, select, nums, i + 1);
            select.remove(select.size() - 1);
        }
    }
}
