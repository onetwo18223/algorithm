package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 不同路径
 * @date Created in 2022-01-25 11:51
 * @modified By
 */
public class Question62 {
    class Solution {
        /*
        求方式 尝试dp 坐标型dp
        1.状态
            dp[m][n] 表示到达某个元素点的不同路劲数量
        2.转换公式
            dp[m][n] = dp[m - 1][n] + dp[m][n - 1];
        3.初始值和边界值
            dp[0][0] = 1;
            dp[0][j] = dp[0][j - 1]
            dp[i][0] = dp[i - 1][0]
        4.顺序
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 1;
                        continue;
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
