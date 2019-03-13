package com.chen.leetcode;

import java.util.Arrays;

/***
 * leetcode :https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

}