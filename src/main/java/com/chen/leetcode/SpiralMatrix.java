package com.chen.leetcode;


/**
 * Created by Chen on 2017/3/28.
 * herf: https://leetcode.com/problems/spiral-matrix-ii/#/description
 */
public class SpiralMatrix {

    public int[][] generateMatrix(int n) {

        int[][] ret = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                ret[top][i] = count++;
            }
            top++;
            for (int i = top; i <= down; i++) {
                ret[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ret[down][i] = count++;
            }
            down--;
            for (int i = down; i >= top; i--) {
                ret[i][left] = count++;
            }
            left++;
        }

        return ret;
    }
}
