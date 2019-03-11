package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {

    public static void main(String[] args) {
        new DuplicatesInArray().findDuplicates2(new int[]{1, 2, 3, 5, 6, 3, 2, 4});
    }

    public List<Integer> findDuplicates2(int[] nums) {
        if (nums == null) return null;
        List<Integer> list = new ArrayList<Integer>();
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - 1] = counts[nums[i] - 1] + 1;
            if (counts[nums[i] - 1] == 2) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
