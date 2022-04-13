package com.bhh.lintcode.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author bhh
 * @description 骑士的最短路线
 * @date Created in 2021-12-10 11:18
 * @modified By
 */
public class Question611 {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public class Solution {
        /*
        与Question433 不同点在于 433不确定起点, 移动限于上下左右一格
        求距离
         */
        int[] deltaX = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

        public int shortestPath(boolean[][] grid, Point source, Point destination) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return -1;
            }

            int line = grid[0].length;
            int destinationCoordinate = destination.x * line + destination.y;
            Queue<Point> queue = new ArrayDeque<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            queue.add(source);
            // 将二维坐标转换为一维坐标进行存储,
            // 不直接使用Point类是因为, 在寻找坐标时, 随时会创建新的Point类
            map.put(source.x * line + source.y, 0);

            while (!queue.isEmpty()) {
                Point element = queue.poll();
                int coordinate = element.x * line + element.y;
                if (coordinate == destinationCoordinate) {
                    return map.get(coordinate);
                }
//                if (element.x == destination.x && element.y == destination.y){
//                    return map.get(coordinate);
//                }
                for (int i = 0; i < 8; i++) {
                    int newX = element.x + deltaX[i];
                    int newY = element.y + deltaY[i];
                    if (isValid(newX, newY, grid, map)) {
                        queue.add(new Point(newX, newY));
                        map.put(newX * line + newY, map.get(coordinate) + 1);
                    }
                }
            }
            return -1;
        }

        private boolean isValid(int x, int y, boolean[][] grid, HashMap<Integer, Integer> map) {
            if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) {
                return false;
            }
            if (map.containsKey(x * grid[0].length + y)) {
                return false;
            }
            return !grid[x][y];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question611().new Solution().shortestPath(new boolean[][]{
                {false, true, false},
                {false, false, false},
                {false, false, false}
        }, new Point(2, 0), new Point(2, 2)));
    }
}
