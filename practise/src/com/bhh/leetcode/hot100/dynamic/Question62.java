package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 不同路径
 * @date Created in 2022-01-02 12:33
 * @modified By
 */
public class Question62 {
    class Solution {
        /*
        求方式/考虑DP/二维数组/坐标型DP
        1.状态
            最后一步 对于grid[m - 1][n - 1]只能由grid[m - 2][n - 1]或者grid[m - 1][n - 2]达到
            子问题 到达grid[i][j]的方式
            dp[i][j]定义为到达grid[i][j]的方式和
        2.转换公式
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        3.初始值和边界值
            dp[0][0] = 1;
        4.顺序
            正序
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 1;
                        continue;
                    }
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
