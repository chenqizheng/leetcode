package com.chen.group.search.dfs;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, word, 0, j, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int depth, int x, int y) {
        if (x < 0 || y < 0 || y >= board.length || x >= board[0].length || word.charAt(depth) != board[y][x]) {
            return false;
        }
        if (depth == word.length() - 1) {
            return true;
        }
        char temp = board[y][x];
        board[y][x] = '.';
        boolean found = search(board, word, depth + 1, x - 1, y) || search(board, word, depth + 1, x + 1, y)
                || search(board, word, depth + 1, x, y - 1) || search(board, word, depth + 1, x, y + 1);
        board[y][x] = temp;
        return found;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch()
                .exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },"SEE"));
    }
}