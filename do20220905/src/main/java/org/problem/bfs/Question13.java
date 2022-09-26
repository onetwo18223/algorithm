package org.problem.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 机器人的运动范围
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * 实现：本题起点被限制在[0,0]，在整个数组范围内我们可以将之分为
 *      可达到且允许，可达到但不允许，不可达到
 *
 */
public class Question13 {
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

        public int movingCount(int m, int n, int k) {
            return bfs(m ,n, k);
        }

        private int bfs(int m, int n, int k) {
            int[][] visited = new int[m][n];
            Deque<Coordinate> deque = new ArrayDeque();
            deque.add(new Coordinate(0, 0));
            visited[0][0] = 1;
            int sum = 1;
            while (!deque.isEmpty()) {
                Coordinate temp = deque.remove();
                for (int i = 0; i < 4; i++) {
                    int newX = temp.x + offsetX[i];
                    int newY = temp.y + offsetY[i];
                    if (!isLegal(newX, newY, m, n, visited, k)) continue;
                    deque.add(new Coordinate(newX, newY));
                    visited[newX][newY] = 1;
                    sum++;
                }
            }
            return sum;
        }

        public boolean isLegal(int x, int y, int m, int n, int[][] visited, int k) {
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == 1) return false;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            while (y > 0) {
                sum += y % 10;
                y /= 10;
            }
            return sum <= k;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question13().new Solution().movingCount(2, 3, 1));
    }
}
