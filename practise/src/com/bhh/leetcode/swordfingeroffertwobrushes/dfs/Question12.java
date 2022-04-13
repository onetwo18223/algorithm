package com.bhh.leetcode.swordfingeroffertwobrushes.dfs;

/**
 * @author bhh
 * @description 矩阵中的路径
 * @date Created in 2022-01-13 9:53
 * @modified By
 */
public class Question12 {
    class Solution {
        /*
        使用bfs/dfs完成
        我的办法是使用前缀来缩减时间复杂度,
            这种方式是生成str和前缀字符串进行比较, 如果有相同的则返回
        也可以使用visited[][]来进行剪枝,
            这种方式是分解word字符串, 利用index来完成一一比较
         */
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || word.length() == 0) {
                return false;
            }
            char[] array = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 将word进行分解比较
                    if (dfs(board, i, j, array, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /*
        递归三要素
         */
        private boolean dfs(char[][] board, int i, int j, char[] array, int index) {
            if (index == array.length) {
                return true;
            }
            if (i >= board.length || i < 0
                    || j >= board[0].length || j < 0
                    || board[i][j] != array[index]) {
                return false;
            }
            board[i][j] = '\0';
            boolean res = dfs(board, i + 1, j, array, index + 1)
                    || dfs(board, i - 1, j, array, index + 1)
                    || dfs(board, i, j + 1, array, index + 1)
                    || dfs(board, i, j - 1, array, index + 1);
            board[i][j] = array[index];
            return res;
        }
    }
}
