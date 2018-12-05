package com.chen.leetcode;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int p = -1, q = -1;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                p = i + 1;
                q = j + 1;
                break;
            }
        }
        return new int[]{p, q};
    }
}
