package com.chen.leetcode;

public class LongestIncreasingSub {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            int sub = nums[i] - nums[i - 1];
            nums[i] = sub;
        }

        int count = 1;
        int max = count;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                count++;
            } else {
                count = 1;
            }
            if(max < count) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestIncreasingSub().findLengthOfLCIS(new int[] {1,3,5,4,7});
    }
}
