package com.bhh.leetcode.four.dp;

/**
 * @author bhh
 * @description 最小路径和
 * @date Created in 2022-03-04 10:51
 * @modified By
 */
public class Question64 {
    class Solution {
        /*
        求最小值, 坐标型dp
        1.状态
            最后一步
                到达最后一个元素的最短路劲是
                    (m - 1的dp / n - 1的dp) + grid[m][n]
            子问题
                每一个元素的最短路劲
        2.公式转换
            dp[m][n] = Math.min(dp[m - 1][n], dp[m][n - 1]) + grid[m][n]
        3.初始值和边界值
        4.顺序
         */
        public int minPathSum(int[][] grid) {
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            int[][] dp = new int[rowLen][lineLen];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    dp[i][j] += grid[i][j];
                }
            }
            return dp[rowLen - 1][lineLen - 1];
        }
    }
}
