package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 最佳买卖股票时机含冷冻期
 * @date Created in 2022-01-21 17:33
 * @modified By
 */
public class Question309 {
    class Solution {
        /*
        求最值, 尝试dp, 坐标型
        1.状态
            dp[len][0] 表示持股状态
            dp[len][1] 表示不持股处于冷冻期
            dp[len][2] 表示不持股正常状态
        2.转换公式
            dp[i][0] = Math.max(dp[i - 1][2] - grid[i], dp[i - 1][0])
            dp[i][1] = dp[i - 1][0] + grid[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        3.初始值和边界值
            dp[0][0] = -grid[0];
            dp[0][1] = 0;
            dp[0][2] = 0;
        4.顺序
         */
        public int maxProfit(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int[][] dp = new int[len][3];
            dp[0][0] = -nums[0];
            dp[0][1] = 0;
            dp[0][2] = 0;
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - nums[i]);
                dp[i][1] = dp[i - 1][0] + nums[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            return Math.max(dp[len - 1][1], dp[len - 1][2]);
        }
    }
}
