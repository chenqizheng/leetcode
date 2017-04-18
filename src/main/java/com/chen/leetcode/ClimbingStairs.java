package com.chen.leetcode;

/**
 * Created by Chen on 2017/4/18.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 3){
            return n;
        }
        int fn1 = 1;
        int fn2 = 2;
        int fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = fn1 + fn2;
            fn1 = fn2;
            fn2 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(4));
    }
}
