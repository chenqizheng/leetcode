package com.chen.leetcode;

import java.util.Arrays;

/**
 * Created by Chen on 2017/3/11.
 */
public class ThreeNumberClosest {
    /**
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = i + 1;
            int j = nums.length - 1;
            while (k < j) {
                int threeNums = nums[i] + nums[j] + nums[k];
                if (Math.abs(threeNums - target) < min) {
                    min = Math.abs(threeNums - target);
                    sum = nums[i] + nums[j] + nums[k];
                }
                if(threeNums - target < 0 ) {
                    k++;
                } else if(threeNums - target > 0 ){
                    j--;
                } else {
                    return sum;
                }

            }
        }

        return sum;
    }

    public static void main(String[] args) {
        ThreeNumberClosest threeNumberClosest = new ThreeNumberClosest();
        int sum = threeNumberClosest.threeSumClosest(new int[]{0,2,1,-3},1);
        System.out.println("sum = " + sum);
    }
}
