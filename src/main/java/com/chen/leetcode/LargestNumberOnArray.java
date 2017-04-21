package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/20.
 */
public class LargestNumberOnArray {

    /**
     * 效率太慢
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums[k - 1];
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length - 1, k -1);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        int p = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] >= p) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }

        int temp = nums[left];
        nums[left] = nums[end];
        nums[end] = temp;
        if (k == left) {
            return nums[left];
        } else if (k > left) {
            return findKthLargest(nums, left + 1, end, k);
        } else {
            return findKthLargest(nums, start, left - 1, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumberOnArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 1));
    }
}
