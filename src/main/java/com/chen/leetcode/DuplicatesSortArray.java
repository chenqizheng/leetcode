package com.chen.leetcode;

/**
 * Created by Chen on 2017/3/31.
 */
public class DuplicatesSortArray {
    public int removeDuplicates(int... nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;

    }

    public static void main(String[] args) {
        new DuplicatesSortArray().removeDuplicates(1, 1, 2, 2, 3, 5);
    }
}
