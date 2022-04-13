package com.bhh.lintcode.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author bhh
 * @description 岛屿的个数
 * @date Created in 2021-12-10 8:59
 * @modified By
 */
public class Question433 {
    public class Solution {
        /*
        计算岛屿数量, 连通块问题, 使用BFS实现
        遍历这个二维数组
        为每一个元素进行BFS遍历, 每一次遍历, 所有为1的元素和相邻的为1的元素都会被标记
        防止岛屿重复
         */
        class Coordinate {
            int x, y;

            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[] deltaX = new int[]{1, -1, 0, 0};
        int[] deltaY = new int[]{0, 0, 1, -1};

        public int numIslands(boolean[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int sum = 0;
            int row = grid.length;
            int line = grid[0].length;
            boolean[][] visited = new boolean[row][line];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < line; j++) {
                    if (grid[i][j] && !visited[i][j]) {
                        // 0,0 0,1 1,4 4,4
                        BFS(i, j, grid, visited);
                        sum++;
                    }
                }
            }
            return sum;
        }

        private void BFS(int x, int y, boolean[][] grid, boolean[][] visited) {
            Queue<Coordinate> queue = new ArrayDeque();
            queue.add(new Coordinate(x, y));
            visited[x][y] = true;
            while (!queue.isEmpty()) {
                Coordinate element = queue.poll();
                // 获取元素上下左右四个元素
                for (int i = 0; i < 4; i++) {
                    int newX = element.x + deltaX[i];
                    int newY = element.y + deltaY[i];
                    if (isVaild(newX, newY, grid, visited)) {
                        queue.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        private boolean isVaild(int x, int y, boolean[][] grid, boolean[][] visited) {
            if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0) {
                return false;
            }
            if (visited[x][y]) {
                return false;
            }
            return grid[x][y];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question433().new Solution().numIslands(new boolean[][]{
                 {true,true,false,false,false},
                 {false,true,false,false,true},
                 {false,false,false,true,true},
                 {false,false,false,false,false},
                 {false,false,false,false,true}
        }));
    }
}
