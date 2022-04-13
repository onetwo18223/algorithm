package com.bhh.leetcode.hot100twobrushes.dfs;

/**
 * @author bhh
 * @description 单词搜索
 * @date Created in 2022-01-22 12:57
 * @modified By
 */
public class Question79 {
    class Solution {
        /*
        dfs, 通过比对word, 让word减少
         */
        int[] offsetX = {0, 0, 1, -1};
        int[] offsetY = {1, -1, 0, 0};

        public boolean exist(char[][] board, String word) {
            int rowLen = board.length;
            int lineLen = board[0].length;
            // dfs递归
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int x, int y, String word, int index) {
            if (index == word.length()) {
                return true;
            }

            if (x < 0 || x >= board.length
                    || y < 0 || y >= board[0].length
                    || board[x][y] != word.charAt(index)) {
                return false;
            }
            board[x][y] = '\0';
            boolean res = false;
            for (int i = 0; i < 4; i++) {
                if (dfs(board, x + offsetX[i], y + offsetY[i], word, index + 1)) {
                    res = true;
                    break;
                }
            }
            board[x][y] = word.charAt(index);
            return res;
        }
    }
}
