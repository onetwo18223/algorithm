package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 最大正方形
 * @date Created in 2022-01-02 20:31
 * @modified By
 */
public class Question221 {
    class Solution {
        /*
        求最大/最小值 /考虑DP/坐标型DP
        1.状态
            最后一步
                对于元素grid[m][n]而言, 如果为0, 则直接不符合条件, 否则需要判断grid[m - 1][n]和grid[m][n - 1]
            子问题
                对于某个元素长宽相等情况下的最大值
            dp[i][j]定义为元素最长正方形边长
        2.转换公式
            dp[i][j] = 0|grid[i][j] == 0

            Error : dp[i][j] = min(dp[i - 1][j], dp[i][j - 1])
            要比较三个条件获取最小值
        3.初始值和边界值
            dp[0][0] = grid[0][0]
            在遍历矩形时初始化dp[i][0]和dp[0][i]
        4.顺序
            正序
         */
        public int maximalSquare(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            int max = Integer.MIN_VALUE;
            int[][] dp = new int[rowLen][lineLen];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < lineLen; j++) {
                    // dp[i][j] = 0|grid[i][j] == 0
                    if (grid[i][j] == '0') {
                        dp[i][j] = 0;
                    }
                    // dp[0][0]初始化
                    else if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    }
                    // dp[0][j]初始化
                    // dp[i][0]初始化
                    else if (i < 1 || j < 1) {
                        dp[i][j] = 1;
                    }
                    // dp[i][j] = max(1, min(dp[i - 1][j], dp[i][j - 1]))
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
            return max * max;
        }
    }
}
