package com.chen.leetcode;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int y1 = 0, y2 = matrix.length - 1;
        int x1 = 0, x2 = matrix[0].length - 1;
        return searchMatrix(matrix, target, x1, x2, y1, y2);
    }

    private boolean searchMatrix(int[][] matrix, int target, int x1, int x2, int y1, int y2) {
        if (y1 == y2) {
            if (x1 == x2) {
                return matrix[y1][x1] == target;
            }
            int midX = (x1 + x2) / 2;
            if (target > matrix[y1][midX]) {
                return searchMatrix(matrix, target, midX + 1, x2, y1, y2);
            } else if (target < matrix[y1][midX]) {
                return searchMatrix(matrix, target, x1, midX, y1, y2);
            } else {
                return true;
            }
        } else {
            int midY = (y1 + y2) / 2;
            if (target > matrix[midY][matrix[0].length - 1]) {
                return searchMatrix(matrix, target, x1, x2, midY + 1, y2);
            } else if (target < matrix[midY][matrix[0].length - 1]) {
                return searchMatrix(matrix, target, x1, x2, y1, midY);
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}
//        };
        int[][] matrix = new int[][]{
                {1,3}
        };
        System.out.print(" result = " + new Search2DMatrix().searchMatrix(matrix, 3));
    }
}
