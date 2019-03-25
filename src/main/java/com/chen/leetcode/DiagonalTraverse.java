package com.chen.leetcode;

public class DiagonalTraverse {


    public static void main(String[] args) {
        int[] result = new DiagonalTraverse().findDiagonalOrder(new int[][]{{1, 2}, {3, 4}});
        for (int i : result) {
            System.out.print(i);
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int[] result = new int[maxCol * maxRow];
        int r = 0;
        int c = 0;
        boolean isUp = true;
        for (int i = 0; i < result.length; i++) {
            if ((r + c) % 2 == 0) {
                if (c == maxCol - 1) {
                    ++r;
                } else if (r == 0) {
                    ++c;
                } else {
                    --r;
                    ++c;
                }
            } else {
                if (r == maxRow - 1) {
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
