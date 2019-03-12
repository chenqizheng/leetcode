package com.chen.leetcode;

public class NumberOfLIS {

    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,4,3,5,4,7,2};
        new NumberOfLIS().findNumberOfLIS(arrays);

    }

    public int findNumberOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int[] counts = new int[nums.length];
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(findLISLength(length, nums, i), maxLength);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (findLISLength(length, nums, i) == maxLength) {
                ans += findLISCount(counts, length, nums, i);
            }
        }
        return ans;
    }

    private int findLISCount(int[] counts, int[] lenght, int[] nums, int index) {
        if (index == 0) {
            return 1;
        }
        if (counts[index] > 0) {
            return counts[index];
        }
        int total = 0;
        int l = findLISLength(lenght, nums, index);
        for (int i = 0; i < index; i++) {
            if (nums[index] > nums[i] && findLISLength(lenght, nums, i) == l - 1) {
                total = total + findLISCount(counts, lenght, nums, i);
            }
        }
        if (total == 0) {
            total = 1;
        }
        counts[index] = total;
        return total;
    }

    public int findLISLength(int[] length, int[] nums, int index) {
        if (index == 0) {
            length[index] = 1;
            return length[index];
        }
        if (length[index] > 0) return length[index];
        int max_lenght = 1;
        for (int i = 0; i < index; i++) {
            if (nums[index] > nums[i]) {
                max_lenght = Math.max(max_lenght, findLISLength(length, nums, i) + 1);
            }
        }
        length[index] = max_lenght;
        return max_lenght;
    }


}
