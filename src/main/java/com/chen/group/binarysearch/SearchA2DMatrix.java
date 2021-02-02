package com.chen.group.binarysearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row * col;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / col][mid % col];
            if (midValue > target) {
                right = mid - 1;
            } else if(midValue < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
