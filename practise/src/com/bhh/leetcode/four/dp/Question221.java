package com.bhh.leetcode.four.dp;

/**
 * @author bhh
 * @description 最大正方形
 * @date Created in 2022-03-04 21:11
 * @modified By
 */
public class Question221 {
    class Solution {
        /*
        尝试dp, 序列性dp
        1.状态
            dp[][] 定义为形成正方形的最大边长
        2.公式转换
            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                dp[i - 1][j - 1]);
        3.初始值和边界值
        4.顺序
         */
        public int maximalSquare(char[][] grid) {
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            int[][] dp = new int[rowLen + 1][lineLen + 1];
            int max = 0;
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
