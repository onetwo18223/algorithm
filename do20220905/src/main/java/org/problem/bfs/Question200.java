package org.problem.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 岛屿数量
 *
 * 实现：BFS
 */
public class Question200 {
    class Solution {
        int[] offsetX = new int[]{0, 0, 1, -1};
        int[] offsetY = new int[]{1, -1, 0, 0};
        class Coordinate {
            int x;
            int y;

            Coordinate() {
            }

            Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0
                    || grid[0].length == 0) return 0;

            int rowLength = grid.length;
            int lineLength = grid[0].length;
            Deque<Coordinate> deque = new ArrayDeque<>();
            int[][] visited = new int[rowLength][lineLength];
            int sum = 0;

            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < lineLength; j++) {
                    if (visited[i][j] == 1 || grid[i][j] == '0') continue;
                    bfs(grid, i, j, deque, visited);
                    sum++;
                }
            }
            return sum;
        }

        private void bfs(char[][] grid, int x, int y,
                         Deque<Coordinate> deque, int[][] visited) {
            deque.add(new Coordinate(x, y));
            visited[x][y] = 1;
            while (!deque.isEmpty()) {
                Coordinate temp = deque.remove();
                for (int i = 0; i < 4; i++) {
                    int newX = temp.x + offsetX[i];
                    int newY = temp.y + offsetY[i];
                    if (!isLegal(grid, newX, newY, visited)) continue;
                    deque.add(new Coordinate(newX, newY));
                    visited[newX][newY] = 1;
                }
            }
        }

        private boolean isLegal(char[][] grid, int x, int y, int[][] visited) {
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                    && visited[x][y] != 1 && grid[x][y] == '1')
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question200().new Solution().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }
}
