package com.chen.leetcode;

public class RepeatedSubarray {


    public static void main(String[] args) {
        System.out.println(new RepeatedSubarray().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int[][] temp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    temp[i][j] = temp[i + 1][j + 1] + 1;
                    if (max < temp[i][j]) {
                        max = temp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
