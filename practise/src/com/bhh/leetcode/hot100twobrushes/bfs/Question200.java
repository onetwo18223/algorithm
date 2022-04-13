package com.bhh.leetcode.hot100twobrushes.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author bhh
 * @description 岛屿数量
 * @date Created in 2022-01-21 11:44
 * @modified By
 */
public class Question200 {
    class Solution {
        /*
        连通块问题, bfs
        使用visited剪枝
        若是被访问过, 或者当前元素是'0'则continue;
         */
        class Coordinate {
            int x;
            int y;

            Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[] offsetX = {0, 0, 1, -1};
        int[] offsetY = {1, -1, 0, 0};

        public int numIslands(char[][] grid) {
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            boolean[][] visited = new boolean[rowLen][lineLen];
            Queue<Coordinate> queue = new ArrayDeque<>();
            int sum = 0;

            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    // 元素本身为'0' 或者 被访问过, 则跳过
                    if (grid[i][j] == '0' || visited[i][j]) {
                        continue;
                    }
                    sum++;
                    bfs(grid, visited, queue, i, j);
                }
            }
            return sum;
        }

        private void bfs(char[][] grid, boolean[][] visited, Queue<Coordinate> queue, int x, int y) {
            queue.add(new Coordinate(x, y));
            visited[x][y] = true;
            while (!queue.isEmpty()) {
                Coordinate element = queue.remove();
                for (int i = 0; i < 4; i++) {
                    int newX = element.x + offsetX[i];
                    int newY = element.y + offsetY[i];
                    if (!valid(grid, visited, newX, newY)) {
                        continue;
                    }
                    queue.add(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }

        private boolean valid(char[][] grid, boolean[][] visited, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }
            if (grid[x][y] == '0') {
                return false;
            }
            return !visited[x][y];
        }
    }
}
