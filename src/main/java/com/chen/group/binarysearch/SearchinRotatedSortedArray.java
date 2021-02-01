package com.chen.group.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int rotateIndex = low;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int realmid = (mid + rotateIndex) % nums.length;
            if (nums[realmid] > target) {
                high = mid - 1;
            } else if (nums[realmid] == target) {
                return realmid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
