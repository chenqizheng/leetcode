package com.chen.group.search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] nums, int k, ArrayList<Integer> currents, List<List<Integer>> result) {
        if (currents.size() > 1) {
            List<Integer> temp = new ArrayList<Integer>(currents);
            result.add(temp);
        }
        Set<Integer> used = new HashSet<>();
        for (int i = k; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (currents.size() == 0 || currents.get(currents.size() - 1) <= nums[i]) {
                currents.add(nums[i]);
                used.add(nums[i]);
                dfs(nums, i + 1, currents, result);
                currents.remove(currents.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new IncreasingSubsequences().findSubsequences(new int[] { 4, 6, 7, 7 });
        for (List<Integer> list : nums) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}