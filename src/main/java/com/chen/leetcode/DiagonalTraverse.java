package com.chen.leetcode;

/***
 * leetcode :https://leetcode.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse {


    public static void main(String[] args) {
        int[] result = new DiagonalTraverse().findDiagonalOrder(new int[][]{{1, 2}, {3, 4}});
        for (int i : result) {
            System.out.print(i);
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;

        int[] result = new int[m * n];
        int r = 0, c = 0;
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    ++r;
                } else if (r == 0) {
                    ++c;
                } else {
                    --r;
                    ++c;
                }
            } else {
                if (r == m - 1) {
                    ++c;
                } else if (c == 0) {
                    ++r;
                } else {
                    ++r;
                    --c;
                }
            }
        }
        return result;
    }
}
