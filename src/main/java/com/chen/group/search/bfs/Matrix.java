package com.chen.group.search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class Matrix {
    public int[][] updateMatrix(final int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        final Queue<int[]> queue = new LinkedList<int[]>();
        int[][] seed = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    seed[i][j] = 1;
                }
            }
        }

        int[][] direction = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                int[] point = queue.poll();
                matrix[point[0]][point[1]] = step;
                for (int[] temp : direction) {
                    int tempI = point[0] + temp[0];
                    int tempJ = point[1] + temp[1];
                 
                    if (tempI < 0 || tempI >= matrix.length || tempJ < 0 || tempJ >= matrix[0].length
                            || seed[tempI][tempJ] == 1) {
                        continue;
                    }
                    queue.offer(new int[] { tempI, tempJ });
                    seed[tempI][tempJ] = 1;

                }
                size--;
            }
            step++;
        }

        return matrix;
    }

    public static void main(final String[] args) {

        int[][] matrix = new Matrix().updateMatrix(new int[][] { {0,0,0}, {0,1,0}, {1,1,1}});

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    static class Point<T, R> {
        T first;
        R second;

        public Point(final T t, final R r) {
            first = t;
            second = r;
        }

    }
}