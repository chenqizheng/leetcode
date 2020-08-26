package com.chen.group.search.partition;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        return dfs(nums, k, target, 0, 0);
    }

    private boolean dfs(int[] nums, int k, int target, int current, int useed) {
        if (k == 0) {
            return  useed == ((1 << nums.length) - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if ((useed & (1 << i)) != 0) {
                continue;
            }
            int t = current + nums[i];
            if (t > target) {
                break;
            }
            int newUseed = useed | (1 << i);
            if (t == target && dfs(nums, k - 1, target, 0, newUseed)) {
                return true;
            } else if (dfs(nums, k, target, t, newUseed)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new PartitionToKEqualSumSubsets().canPartitionKSubsets(new int[]{18,20,39,73,96,99,101,111,114,190,207,295,471,649,700,1037}, 4);
    }
}