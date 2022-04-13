package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 买卖股票的最佳时机
 * @date Created in 2022-01-03 8:56
 * @modified By
 */
public class Question121 {
    class Solution {
        /*
        股票系列问题, 第一题
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(prices[i], min);
                max = Math.max(prices[i] - min, max);
            }
            return max;
        }

        /*
        使用DP完成
        1.状态
            定义为dp[len + 1][2]
            dp[i][0]定义为在第几天时候手里没有股票时的最大收益
            dp[i][1]定义为在第几天时候手有股票时的最大收益
        2.转换公式
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][0] - prices[i], dp[i - 1][1])
        3.初始值和边界值
            dp[0][0] = 0
            dp[0][1] = 0
        4.顺序
            正序
         */
        public int maxProfitDP(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int len = prices.length;
            int[][] dp = new int[len + 1][2];
            dp[0][0] = 0;
            dp[0][1] = Integer.MIN_VALUE;
            for (int i = 1; i < len + 1; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(-prices[i - 1], dp[i - 1][1]);
            }
            return dp[len][0];
        }
    }
}
