package com.bhh.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 单词搜索
 * @date Created in 2021-12-21 15:38
 * @modified By
 */
public class Question79 {
    class Solution {
        /*
        求路径, 这个问题可以使用DFS或者BFS
        优化 : 为word创建一个前缀集合可以提高效率
         */
        private int[] OffsetX = {0, 0, 1, -1};
        private int[] OffsetY = {1, -1, 0, 0};

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 ||
                    board[0] == null || board[0].length == 0) {
                return false;
            }

            boolean[][] visited = new boolean[board.length][board[0].length];
            // 获取前缀和
            List<String> pres = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                pres.add(word.substring(0, i + 1));
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    visited[i][j] = true;
                    if (dfs(board, i, j, visited, pres, "" + board[i][j], word)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int x, int y, boolean[][] visited,
                            List<String> pres, String str, String target) {
            if (!pres.contains(str)) {
                return false;
            }
            if (target.equals(str)) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newX = x + OffsetX[i];
                int newY = y + OffsetY[i];
                if (!valida(board, visited, newX, newY)) {
                    continue;
                }
                visited[newX][newY] = true;
                if (dfs(board, newX, newY, visited, pres, str + board[newX][newY], target)) {
                    return true;
                }
                visited[newX][newY] = false;
            }
            return false;
        }

        private boolean valida(char[][] board, boolean[][] visited, int newX, int newY) {
            if (newX < 0 || newX >= board.length
                    || newY < 0 || newY >= board[0].length) {
                return false;
            }
            return !visited[newX][newY];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question79().new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
    }
}
