package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 最佳买卖股票时机含冷冻期
 * @date Created in 2022-01-03 9:34
 * @modified By
 */
public class Question309 {
    class Solution {
        /*
        股票系列扩展第一题
        1.状态
            dp[len + 1][3] 三个状态
            dp[i][0] 持股的最大利润
            dp[i][1] 不持股处于冷冻期的最大利润
            dp[i][2] 不持股不处于冷冻期的最大利润
        2.转换公式
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i - 1])
            dp[i][1] = dp[i - 1][0] + prices[i - 1]
            dp[i][2] = max(dp[i - 1][1], dp[i - 1][2])
        3.初始值和边界值
        dp[0][0] = dp[0][1] = dp[0][2] = 0
        4.顺序
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int len = prices.length;
            int[][] dp = new int[len][3];
            dp[0][0] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            return Math.max(dp[len - 1][1], dp[len - 1][2]);
        }
    }
}
