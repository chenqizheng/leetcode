package com.chen.leetcode;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sumOfArray = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOfArray = sumOfArray + nums[i];
        }
        int max = nums.length;
        int sum;
        if (nums.length % 2 == 0) {
            sum = max * nums.length / 2 + max / 2;
        } else {
            sum = max * ((nums.length + 1) / 2);
        }
        return sum - sumOfArray;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 2 , 0, 1}));
    }
}
