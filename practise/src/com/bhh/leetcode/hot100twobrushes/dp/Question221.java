package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 最大正方形
 * @date Created in 2022-01-21 17:45
 * @modified By
 */
public class Question221 {
    class Solution {
        /*
        求最值 尝试dp 坐标型
        1.状态
            dp[m + 1][n + 1]定义为以某个元素为右下角形成的正方形最长边长
        2.转换公式
            三个因素 : dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]
            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])
            | grid[i - 1][j - 1] == '1'
        3.初始值和边界值
            dp[0][0], dp[0][j], dp[i][0] 都是0
        4.顺序
            正序
         */
        public int maximalSquare(char[][] grid) {
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            int max = 0;
            int[][] dp = new int[rowLen + 1][lineLen + 1];
            for (int i = 1; i < rowLen + 1; i++) {
                for (int j = 1; j < lineLen + 1; j++) {
                    if (grid[i - 1][j - 1] == '0') {
                        continue;
                    }
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
            return max;
        }
    }
}
