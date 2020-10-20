package com.chen.group.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.add(new Integer(i * grid[i].length + j));
                    while (queue.size() > 0) {
                        int id = queue.poll();
                        int row = id / grid[i].length;
                        int col = id % grid[i].length;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            queue.add((row-1) * grid[0].length + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < grid.length && grid[row+1][col] == '1') {
                            queue.add((row+1) * grid[0].length + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            queue.add(row * grid[0].length + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < grid[0].length && grid[row][col+1] == '1') {
                            queue.add(row * grid[0].length + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
