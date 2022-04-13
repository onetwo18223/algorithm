package com.bhh.leetcode.swordfingeroffertwobrushes.array.dp;

/**
 * @author bhh
 * @description 礼物的最大价值
 * @date Created in 2022-01-13 9:41
 * @modified By
 */
public class Question47 {
    class Solution {
        /*
        求最值/dp/坐标型dp
        1.状态
            dp[m][n]定义为第grid[m][n]元素最大的礼物价值
            dp[m][n]的值等于上边与左边元素的最大值加上本身元素
        2.转换公式
            dp[m][n] = max(dp[m - 1][n], dp[m][n - 1]) + grid[m][n];
        3.初始值和边界值
            dp[0][0] = grid[0][0]
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        4.顺序
            正序
         */
        public int maxValue(int[][] grid) {
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            int[][] dp = new int[rowLen][lineLen];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (i < 1 && j < 1) {
                        dp[i][j] = grid[0][0];
                        continue;
                    }
                    if (i < 1) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                        continue;
                    }
                    if (j < 1) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[rowLen - 1][lineLen - 1];
        }
    }
}
