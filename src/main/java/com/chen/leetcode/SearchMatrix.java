package com.chen.leetcode;

/**
 * Created by Chen on 2017/3/30.
 * <p>
 * herf = https://leetcode.com/problems/search-a-2d-matrix-ii/#/description;
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            }
        }


        return false;
    }

    public static void main(String[] args) {

    }
}
