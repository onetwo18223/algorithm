package org.problem.dp;

/**
 * 买卖股票的最佳时机含手续费
 *
 * 实现
 * 1.1 定义
 *      dp[i][0] 表示不持有股票
 *      dp[i][0] 表示持有股票
 * 1.2 最后一步
 * 2 转换公式
 * 3 初始值和边界值
 *      dp[0][0] = 0, dp[0][1] = -prices[0]
 * 4 顺序
 */
public class Question714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) return 0;
            int len = prices.length;
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < len; i++) {
                // 不持有股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                // 持有股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }
    }
}
