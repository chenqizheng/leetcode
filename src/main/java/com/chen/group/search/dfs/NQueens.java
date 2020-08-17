package com.chen.group.search.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        boolean[] columns = new boolean[n * 2 - 1];
        boolean[] diag1 = new boolean[n * 2 - 1];
        boolean[] diag2 = new boolean[n * 2 - 1];
        nQueens(0, n, board, columns, diag1, diag2, new ArrayList<String>(), result);
        return result;
    }

    private void nQueens(int line, int n, List<String> board, boolean[] columns, boolean[] diag1, boolean[] diag2,
            ArrayList<String> arrayList, List<List<String>> result) {
        if (line == n) {
            result.add(new ArrayList<String>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (columns[col] || diag1[col + line] || diag2[col - line + n - 1]) {
                continue;
            }
            updateBoard(col, line, n, columns, diag1, diag2, board, true);
            nQueens(line + 1, n, board, columns, diag1, diag2, arrayList, result);
            updateBoard(col, line, n, columns, diag1, diag2, board, false);
        }
    }

    private void updateBoard(int col, int line, int n, boolean[] columns, boolean[] diag1, boolean[] diag2,
            List<String> board, boolean isQueen) {
        columns[col] = isQueen;
        diag1[col + line] = isQueen;
        diag2[col - line + n - 1] = isQueen;

        String temp = board.remove(line);
        StringBuilder sb = new StringBuilder(temp);
        board.add(line, sb.replace(col, col + 1, isQueen ? "Q" : ".").toString());
    }

    public static void main(String[] args) {
        List<List<String>> result = new NQueue().solveNQueens(8);
        for (int i = 0; i < result.size(); i++) {
            for (String str : result.get(i)) {
                System.out.println(str);
            }
            System.out.println("================================");
        }
    }

}