package com.bhh.lintcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bhh
 * @description 单词搜索 II
 * @date Created in 2021-12-11 11:16
 * @modified By
 */
public class Question132 {
    public class Solution {
        /*
        这道题如何决定使用DFS?
        因为涉及到路劲且输出中的多个方案
        BFS一般返回一个数字, 结果, 而DFS一般返回集合, 方案集合

        我感觉, 矩阵中的遍历, 一般来说并没有严格的BFS, DFS之分
        这道题是需要返回集合中正确的路径
        如果一直不断寻找, 遍历每一个点进行dfs来寻找
         */
        int[] deltaX = new int[]{1, -1, 0, 0};
        int[] deltaY = new int[]{0, 0, 1, -1};

        public List<String> wordSearchII(char[][] board, List<String> words) {
            if (board == null || board.length == 0 ||
                    board[0] == null || board[0].length == 0) {
                return new ArrayList<>();
            }
            boolean[][] visited = new boolean[board.length][board[0].length];

            // 获取所有前缀字符串
            Set<String> preSet = new HashSet<>();
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    preSet.add(word.substring(0, i + 1));
                }
            }
            Set<String> resultSet = new HashSet<>();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    visited[i][j] = true;
                    dfs(board, i, j, "" + board[i][j], preSet, words, resultSet, visited);
                    visited[i][j] = false;
                }
            }
            return new ArrayList<>(resultSet);
        }

        private void dfs(char[][] board, int x, int y, String path,
                         Set<String> preSet, List<String> words, Set<String> resultSet,
                         boolean[][] visited) {
            if (!preSet.contains(path)) {
                return;
            }
            // 这里不return是因为, 可能还有其他word
            if (words.contains(path)) {
                resultSet.add(path);
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + deltaX[i];
                int newY = y + deltaY[i];
                if (!isValid(board, newX, newY, visited)) {
                    continue;
                }
                visited[newX][newY] = true;
                dfs(board, newX, newY, path + board[newX][newY],
                        preSet, words, resultSet, visited);
                visited[newX][newY] = false;
            }
        }

        private boolean isValid(char[][] board, int x, int y,
                                boolean[][] visited) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                return false;
            }
            return !visited[x][y];
        }
    }
}
