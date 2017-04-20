package com.chen.leetcode;

/**
 * herf : https://leetcode.com/problems/number-of-islands/#/solutions
 * 需要考虑工字形状的岛屿,边遍历边改
 * Created by Chen on 2017/4/20.
 */
public class NumsOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    editMap(grid, i, j);
                }
            }
        }
        return count;
    }

    public void editMap(char[][] grid, int x, int y) {
        if (x >= grid.length || y >= grid[0].length) {
            return;
        }
        grid[x][y] = 'x';
        if (x + 1 < grid.length && grid[x + 1][y] == '1' || x == grid.length - 1)
            editMap(grid, x + 1, y);
        if (y + 1 < grid[0].length && grid[x][y + 1] == '1' || y == grid[0].length - 1)
            editMap(grid, x, y + 1);
        if (y > 0 && grid[x][y - 1] == '1') {
            editMap(grid, x, y - 1);
        }
        if (x > 0 && grid[x - 1][y] == '1') {
            editMap(grid, x - 1, y);
        }
    }

    public static void main(String[] args) {
//        char[][] grid = new char[][]{
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };
        char[][] grid = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
        };
        int count = new NumsOfIslands().numIslands(grid);
        System.out.println("count = " + count);

    }
}
