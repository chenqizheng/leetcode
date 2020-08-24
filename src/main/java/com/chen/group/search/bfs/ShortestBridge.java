package com.chen.group.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean found = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length&& !found; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    found = true;
                }
            }
        }
        int step = 0;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
               int[] temp = queue.poll();
                for (int i = 0; i < dirs.length; i++) {
                    int m = temp[0] + dirs[i][0];
                    int n = temp[1] + dirs[i][1];
                    if (m < 0 || n < 0 || m >= A.length || n >= A[0].length || A[m][n] == 2) {
                        continue;
                    }
                    if (A[m][n] == 1) {
                        return step;
                    }
                    A[m][n] = 2;
                    queue.offer(new int[] { m, n });
                }
                size--;
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] A, int x, int y, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] != 1) {
            return;
        }
        A[x][y] = 2;
        queue.offer(new int[] { x, y });
        dfs(A, x - 1, y, queue);
        dfs(A, x, y - 1, queue);
        dfs(A, x + 1, y, queue);
        dfs(A, x, y + 1, queue);
    }

    public static void main(String[] args) {
        int step = new ShortestBridge().shortestBridge(new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } });

        System.out.println(step);

    }

}