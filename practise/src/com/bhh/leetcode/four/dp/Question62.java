package com.bhh.leetcode.four.dp;

/**
 * @author bhh
 * @description 不同路径
 * @date Created in 2022-03-04 8:41
 * @modified By
 */
public class Question62 {
    class Solution {
        /*
        DP, 求方式, 坐标型dp
        1.状态
            最后一步
                最后一个元素方式 = 前一个元素方式之和
            子问题
                每一个元素的方式
        2.公式转换
            dp[rowLen - 1][lineLen - 1] =
                dp[rowLen - 1 - 1][lineLen - 1] +
                dp[rowLen - 1][lineLen - 1 - 1]
        3.初始值和边界值
        4.顺序
            正序
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
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
