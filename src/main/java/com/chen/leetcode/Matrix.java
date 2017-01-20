package com.chen.leetcode;

/**
 * Created by Chen on 2017/1/20.
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        printMatrix(matrix);

    }

    /***
     * 矩阵对角线打印
     * <p>
     * { 1  2  3  4 }
     * { 5  6  7  8 }
     * { 9 10 11 12 }
     * {13 14 15 16 }
     * <p>
     * <p>
     * 4
     * 3 8
     * 2 7 12
     * 1 6 11 16
     * 5 10 15
     * 9 14
     * 13
     *
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        int indexX = 3;
        int indexY = 0;
        int line = 0;
        for (int i = 0; i < n * n; i++) {
            System.out.println(matrix[indexY][indexX]);
//            System.out.println("line = " + line);
            if (indexX >= 3) {
                if (indexY < 3) {
                    line++;
                    indexX = n - 1 - line;
                    indexY = 0;
                } else {
                    line++;
                    indexY = (line - n + 1);
                    indexX = 0;
                }
            } else {

                if (indexY < 3) {
                    indexX++;
                    indexY++;
                } else {
                    line++;
                    indexY = (line - n + 1);
                    indexX = 0;
                }
            }
        }
    }
}
