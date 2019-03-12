package com.chen.leetcode;

public class MinSizeSubArraySum {

    public static void main(String[] args) {
        new MinSizeSubArraySum().minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8});

    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > s) {
                min = Math.min(min, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
