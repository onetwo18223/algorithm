package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description  最佳买卖股票时机含冷冻期
 * @date Created in 2022-01-29 11:20
 * @modified By
 */
public class Question309hot100 {
    class Solution {
        /*
        求最值 尝试dp 坐标型dp
        1.状态
            dp[len][3] 表示不同状态下的前i天的最大收益
            dp[i][0] 表示持有股票
            dp[i][1] 表示不持有 且不处于冷冻期
            dp[i][2] 表示不持有 且处于冷冻期
        2.转换公式
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - nums[i])
            dp[i][1] = max(dp[i - 1][2], dp[i - 1][1])
            dp[i][2] = max(dp[i - 1][0] + nums[i])
        3.初始值和边界值
        4.顺序
         */
        public int maxProfit(int[] nums) {
            int len = nums.length;
            int[][] dp = new int[len][3];
            dp[0][0] = -nums[0];
            dp[0][1] = 0;
            dp[0][2] = 0;
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
                dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);
                dp[i][2] = dp[i - 1][0] + nums[i];
            }
            return Math.max(dp[len - 1][1], dp[len - 1][2]);
        }
    }
}
