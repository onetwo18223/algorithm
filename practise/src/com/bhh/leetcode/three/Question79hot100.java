package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 单词搜索
 * @date Created in 2022-01-31 16:43
 * @modified By
 */
public class Question79hot100 {
    class Solution {
        /*
        dfs遍历word
        使用index
         */
        int[] offsetX = {1, -1, 0, 0};
        int[] offsetY = {0, 0, 1, -1};

        public boolean exist(char[][] matrix, String word) {
            int rowLen = matrix.length;
            int lineLen = matrix[0].length;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (dfs(matrix, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] matrix, int x, int y, String word, int index) {
            if (index == word.length()) {
                return true;
            }
            if (x < 0 || x >= matrix.length ||
                    y < 0 || y >= matrix[0].length ||
                    matrix[x][y] != word.charAt(index)) {
                return false;
            }

            boolean res = false;
            for (int i = 0; i < 4; i++) {
                int newX = x + offsetX[i];
                int newY = y + offsetY[i];
                // 如果不越界
                matrix[x][y] = ' ';
                res |= dfs(matrix, newX, newY, word, index + 1);
                matrix[x][y] = word.charAt(index);
            }
            return res;
        }

    }
}
