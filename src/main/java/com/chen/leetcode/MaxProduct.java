package com.chen.leetcode;

public class MaxProduct {

    public static double maxProduct(int[] nums) {
       double[] minRet = new double[nums.length];
       double[] maxRet = new double[nums.length];
       double max = nums[0];
       minRet[0] = nums[0];
       maxRet[0] = nums[0];
       for(int i= 1;i<nums.length;i++){
            minRet[i] = Math.min(Math.min(nums[i],minRet[i-1] * nums[i]),maxRet[i-1] * nums[i]);
            maxRet[i] = Math.max(Math.max(nums[i],maxRet[i-1] * nums[i]),minRet[i-1] * nums[i]);
            if(maxRet[i] > max){
                max = maxRet[i];
            }
       }
       return max;
    }
}
