package com.chen.leetcode;

/**
 * leetcode:https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {
    int[] dp;

    public int integerBreak(int n) {
        if (n == 0) {
            return 1;
        }
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        return helper(n);
    }

    public int helper(int n) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.max(Math.max((n - i) * i, (n - i) * helper(i)), Math.max(helper(n - i) * i, helper(n - i) * helper(i)));
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }


    public static void main(String[] args) {

    }
}
