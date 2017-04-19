package com.chen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chen on 2017/3/11.
 */
public class FourNumber {
    public static void main(String[] args) {
        int[] array = new int[]{0,0,0,0};
        FourNumber fourNumber = new FourNumber();
        System.out.println(fourNumber.fourSum1(array, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            int j = nums.length - 1;
            int tempTarget = target - nums[i] - nums[j];
        }
        return list;
    }


    /**
     * 超过时间限制
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        System.out.println(System.currentTimeMillis());
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            int k = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int p = k; p < nums.length - 2; p++) {
                int q = p + 1;
                int j = nums.length - 1;
                while (q < j && (p == k || nums[p] != nums[p - 1])) {
                    int sum = nums[i] + nums[q] + nums[p] + nums[j];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[p], nums[q], nums[j]));
                        while (q < j && nums[q] == nums[q + 1]) q++;
                        while (q < j && nums[j] == nums[j - 1]) j--;
                        q++;
                        j--;
                    } else if (sum < target) {
                        q++;
                    } else {
                        j--;
                    }
                }
            }

        }
        System.out.println(System.currentTimeMillis());
        return list;
    }
}
