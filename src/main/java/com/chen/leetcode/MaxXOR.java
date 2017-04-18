package com.chen.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chen on 2017/4/18.
 */
public class MaxXOR {
    //TODO 异否
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<Integer>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxXOR().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
