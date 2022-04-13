package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 最小路径和
 * @date Created in 2022-01-02 10:26
 * @modified By
 */
public class Question64 {
    class Solution {
        /*
        最小路径和/ 求最小值/ 可以考虑DP和DFS/ 坐标型DP
        DFS接近于暴力解法, 复杂度较高
        1.状态
            最后一步 必须由左上角走到右下角, 到grid[m - 1][n - 1]的最小路径和就是求到
            grid[m - 2][n - 1]和grid[m - 1][n - 2]最小值
            定义dp[m][n], 表示到某个位置的最小路径和
        2.转换公式
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        3.初始值和边界值
            最上边和最右边的最小路径和只能是一路相加的值
        4.顺序
            正序
         */
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int rowLen = grid.length;
            int lineLen = grid[0].length;
            // 定义dp, 并初始化dp[0][0], dp[0][i], dp[i][0]
            int[][] dp = new int[rowLen][lineLen];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < rowLen; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < lineLen; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < rowLen; i++) {
                for (int j = 1; j < lineLen; j++) {
                    // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[rowLen - 1][lineLen - 1];
        }
    }
}
