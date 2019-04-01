package com.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode :https://leetcode.com/problems/spiral-matrix/
 */
public class RoundPrint {

    public static void main(String[] args) {
        new RoundPrint().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int r = 0;
        int c = 0;
        int startR = 0;
        int startC = 0;
        int endR = row;
        int endC = column;
        int direction = 0;
        for (int i = 0; i < row * column; i++) {

            if (c == endC && direction == 0) {
                direction++;
                c--;
                r++;
            } else if (r == endR && direction == 1) {
                direction++;
                r--;
                c--;
            } else if (c == startC - 1 && direction == 2) {
                direction++;
                c++;
                r--;
            } else if (r == startR && direction == 3) {
                direction = 0;

                startR = startR + 1;
                startC = startC + 1;
                r = startR;
                c = startC;
                endC = endC - 1;
                endR = endR - 1;
            }
            result.add(matrix[r][c]);
            if (direction == 0) {
                c++;
            } else if (direction == 1) {
                r++;
            } else if (direction == 2) {
                c--;
            } else {
                r--;
            }

        }
        return result;
    }
}
