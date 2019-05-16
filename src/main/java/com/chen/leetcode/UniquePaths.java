package com.chen.leetcode;

import java.util.ArrayList;

public class UniquePaths {

    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }


    /***
     *  穷举找路径，时间超出了
     */
    public int uniquePaths(int m, int n) {
        int[][] direction = new int[][]{{0, 1}, {1, 0}};
        ArrayList<ArrayList<Point>> result = new ArrayList<>();
        ArrayList<Point> list = new ArrayList<>();
        dfs(result, list, direction, 0, 0, m - 1, n - 1);
        return result.size();
    }

    private void dfs(ArrayList<ArrayList<Point>> result, ArrayList<Point> list, int[][] direction, int currentM, int currentN, int m, int n) {
        if (currentM == m && currentN == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int[] temp : direction) {
            int tempM = currentM + temp[0];
            int tempN = currentN + temp[1];
            if (tempM > m || tempN > n) {
                continue;
            }
            list.add(new Point(tempM, tempN));
            dfs(result, list, direction, tempM, tempN, m, n);
            list.remove(list.size() - 1);
        }
    }


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new UniquePaths().uniquePaths2(7, 3);
    }
}
