package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 最小路径和
 * @date Created in 2022-01-21 15:07
 * @modified By
 */
public class Question64 {
    class Solution {
        /*
        从左上到右下的最小值, 求最值, 尝试dp, 坐标型dp
        1.状态
            dp[m][n] 定义为到达某个元素的最小路径和
        2.转换公式
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        3.初始值和边界值
            dp[0][0] = grid[0][0]
            i < 1 dp[i][j] = dp[i][j - 1] + grid[i][j]
            j < 1 同理
        4.顺序
         */
        public int minPathSum(int[][] grid) {
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            int[][] dp = new int[rowLen][lineLen];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (i < 1 && j < 1) {
                        dp[i][j] = grid[i][j];
                        continue;
                    }
                    if (i < 1) {
                        dp[i][j] += dp[i][j - 1] + grid[i][j];
                        continue;
                    }
                    if (j < 1) {
                        dp[i][j] += dp[i - 1][j] + grid[i][j];
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) +
                            grid[i][j];
                }
            }
            return dp[rowLen - 1][lineLen - 1];
        }
    }
}
