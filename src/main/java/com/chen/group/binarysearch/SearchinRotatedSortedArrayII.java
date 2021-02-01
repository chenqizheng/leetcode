package com.chen.group.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (!isBinarySearchHelpful(nums, low, nums[mid])) {
                low++;
                continue;
            }
            boolean midInFirst = existInFirst(nums,low,nums[mid]);
            boolean targetInFirst = existInFirst(nums,low,target);
            if(midInFirst ^ targetInFirst) {
                if(midInFirst) {
                    low = mid + 1;;
                } else {
                    high = mid - 1;
                }
            } else {
                if(nums[mid ] < target) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }
        return false;
    }

    public boolean isBinarySearchHelpful(int[] nums, int low, int mid) {
        return nums[low] != mid;
    }

    public boolean existInFirst(int[] nums,int start, int element) {
        return nums[start] <= element;
    }
}
