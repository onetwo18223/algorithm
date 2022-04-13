package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 最大正方形
 * @date Created in 2022-01-30 22:52
 * @modified By
 */
public class Question221hot100 {
    class Solution {
        /*
        求最值 使用dp
        1.状态
            dp记录最大正方形的边长
        2.转换公式
        3.初始值和边界值
        4.顺序
         */
        public int maximalSquare(char[][] matrix) {
            int rowLen = matrix.length;
            int lineLen = matrix[0].length;
            int[][] dp = new int[rowLen + 1][lineLen + 1];
            int max = 0;
            for (int i = 1; i < rowLen + 1; i++) {
                for (int j = 1; j < lineLen + 1; j++) {
                    if (matrix[i - 1][j - 1] == '0') {
                        continue;
                    }
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],
                            dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
            return max;
        }
    }
}
