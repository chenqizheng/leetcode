package com.chen.group.binarysearch;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] < nums[mid + 1]) {
            return findPeakElement(nums, mid + 1, right);
        } else {
            return findPeakElement(nums, left, mid);
        }
    }
}
