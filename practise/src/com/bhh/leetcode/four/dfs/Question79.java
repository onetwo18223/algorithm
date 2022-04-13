package com.bhh.leetcode.four.dfs;

/**
 * @author bhh
 * @description 单词搜索
 * @date Created in 2022-03-04 20:10
 * @modified By
 */
public class Question79 {
    class Solution {
        /*
        通过dfs进行查找
        visited 剪枝 + (word + index 匹配 剪枝)
         */
        int[] offsetX = {0, 0, 1, -1};
        int[] offsetY = {1, -1, 0, 0};

        public boolean exist(char[][] board, String word) {
            int rowLen = board.length;
            int lineLen = board[0].length;
            boolean[][] visited = new boolean[rowLen][lineLen];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    visited[i][j] = true;
                    if (dfs(board, visited, i, j, word, 0)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, boolean[][] visited,
                            int x, int y, String word, int index) {
            if (board[x][y] != word.charAt(index)) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            boolean res = false;
            for (int i = 0; i < 4; i++) {
                int newX = x + offsetX[i];
                int newY = y + offsetY[i];
                if (valid(board, visited, newX, newY)) {
                    visited[newX][newY] = true;
                    res |= dfs(board, visited, newX, newY, word, index + 1);
                    visited[newX][newY] = false;
                }
            }
            return res;
        }

        private boolean valid(char[][] board, boolean[][] visited,
                              int newX, int newY) {
            if (newX >= board.length || newX < 0 ||
                    newY >= board[0].length || newY < 0) {
                return false;
            }
            return !visited[newX][newY];
        }
    }
}
