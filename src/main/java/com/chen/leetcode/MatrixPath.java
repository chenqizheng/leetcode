package com.chen.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixPath {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int i = cell[0] + dir[0];
                int j = cell[1] + dir[1];
                if (i < 0 || i >= m || j < 0 || j >= n ||
                        matrix[i][j] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.offer(new int[]{i, j});
                matrix[i][j] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        return matrix;
    }
}
