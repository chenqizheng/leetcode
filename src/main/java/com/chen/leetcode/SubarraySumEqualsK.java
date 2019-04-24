package com.chen.leetcode;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int result = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k) {
                    result++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        new SubarraySumEqualsK().subarraySum(new int[]{28, 54, 7, -70, 22, 65, -6}, 100);
    }
}
