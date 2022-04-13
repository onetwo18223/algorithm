package com.bhh.leetcode.hot100.array;

import com.bhh.lintcode.bfs.Question433;
import com.sun.scenario.effect.Offset;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 岛屿数量
 * @date Created in 2021-12-21 20:37
 * @modified By
 */
public class Question200 {
    class Solution {
        /*
        标准的连通块问题 => BFS
         */
        class Coordinate {
            int x;
            int y;

            Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private int[] offsetX = {0, 0, 1, -1};
        private int[] offsetY = {1, -1, 0, 0};

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0
                    || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int sum = 0;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '0' || visited[i][j]) {
                        continue;
                    }
                    bfs(grid, visited, i, j);
                    sum++;
                }
            }
            return sum;
        }

        private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
            Deque<Coordinate> queue = new ArrayDeque();
            queue.push(new Coordinate(x, y));
            visited[x][y] = true;
            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.pop();
                for (int i = 0; i < 4; i++) {
                    int newX = coordinate.x + offsetX[i];
                    int newY = coordinate.y + offsetY[i];
                    if (!valida(grid, visited, newX, newY)) {
                        continue;
                    }
                    visited[newX][newY] = true;
                    queue.push(new Coordinate(newX, newY));
                }
            }

        }

        private boolean valida(char[][] grid, boolean[][] visited, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }
            if (grid[x][y] == '0') {
                return false;
            }
            return !visited[x][y];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question200().new Solution().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}

        }));
    }

}
