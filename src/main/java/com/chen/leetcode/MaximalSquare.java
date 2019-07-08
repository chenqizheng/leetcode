package com.chen.leetcode;

/***
 * leetcode:https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];
        int maxsqlen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    if (dp[i + 1][j + 1] > maxsqlen) {
                        maxsqlen = dp[i + 1][j + 1];
                    }
                }
            }
        }

        return maxsqlen * maxsqlen;
    }
}
