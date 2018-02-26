package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        handle(subsets, new ArrayList<Integer>(), nums, 0);
        return subsets;
    }

    public void handle(List<List<Integer>> lists, List<Integer> temp, int[] nums, int start) {
        lists.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            handle(lists, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}
