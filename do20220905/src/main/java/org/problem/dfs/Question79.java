package org.problem.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索
 * <p>
 * 实现：判断矩阵中的某条路径是否包含字符串word
 * 感悟：DFS和BFS的相似性很大，无非一个是使用队列横向扩展，另一个是利用递归纵向扩展，
 *      但是在矩阵的条件下，横向扩展和纵向扩展实现效果是一样的
 */
public class Question79 {
    class Solution {
        // 偏移量
        int[] offsetX = new int[]{0, 0, -1, 1};
        int[] offsetY = new int[]{1, -1, 0, 0};

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0
                    || board[0] == null || board[0].length == 0
                    || word == null || "".equals(word)) return false;

            boolean[][] visited = new boolean[board.length][board[0].length];
            List<String> pres = new ArrayList<>();

            // 获取前缀和集合
            for (int i = 0; i < word.length(); i++) {
                pres.add(word.substring(0, i + 1));
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    visited[i][j] = true;
                    if (dfs(board, i, j, visited, pres, "" + board[i][j], word))
                        return true;
                    visited[i][j] = false;
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int x, int y, boolean[][] visited,
                            List<String> pres, String str, String word) {
            if (!pres.contains(str) || str.length() > word.length()) return false;
            if (str.equals(word)) return true;

            for (int i = 0; i < 4; i++) {
                int newX = x + offsetX[i];
                int newY = y + offsetY[i];
                if (!isLegal(board, visited, newX, newY)) continue;
                visited[newX][newY] = true;
                if (dfs(board, newX, newY, visited, pres,
                        str + board[newX][newY], word))
                    return true;
                visited[newX][newY] = false;
            }
            return false;
        }

        private boolean isLegal(char[][] board, boolean[][] visited,
                                int x, int y) {
            if (x >= 0 && x < board.length
                    && y >= 0 && y < board[0].length && !visited[x][y])
                return true;
            return false;
        }
    }
}
