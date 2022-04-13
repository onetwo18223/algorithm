package com.bhh.leetcode.swordfingeroffer.dynamic;

/**
 * @author bhh
 * @description 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
 * 直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * @date Created in 2021-10-10 18:08
 * @modified By
 */
public class Question47 {
    class Solution {
        /*
         */
        public int maxValue(int[][] grid) {
            int row = grid.length;
            int line = grid[0].length;
            int[][] memo = new int[row][line];

            memo[0][0] = grid[0][0];
            for (int i = 1; i < line; i++) {
                memo[0][i] = memo[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < row; i++) {
                for (int j = 0; j < line; j++) {
                    memo[i][j] = grid[i][j] + Math.max(memo[i][(j - 1) >= 0 ? (j - 1) : 0], memo[i - 1][j]);
                }
            }

            return memo[row - 1][line - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question47().new Solution().maxValue(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }
}
