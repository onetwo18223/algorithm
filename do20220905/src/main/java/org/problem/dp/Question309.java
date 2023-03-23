package org.problem.dp;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * 实现
 * 定义 ：
 *      dp[i][0] = 不持有股票
 *      dp[i][1] = 不持有股票且处于冷冻期
 *      dp[i][2] = 持有股票
 * 1.1 最后一步
 *      最后一个元素 不持有股票 = max（前面不持有股票， 不持有股票且冷冻期）
 *      最后一个元素 不持有股票且处于冷冻期 = 持有股票 + prices[i]
 *      最后一个元素 持有股票 = max（前面持有股票， 不持有股票 - prices[i]）
 * 1.2 子问题
 * 2 转换公式
 *      dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
 *      dp[i][1] = dp[i - 1][2] + prices[i]
 *      dp[i][2] = max(dp[i - 1][2], dp[i - 1][0] - prices[i])
 * 3 初始值和边界值
 *      dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = -prices[0]
 * 4 顺序
 */
public class Question309 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int len = prices.length;
            int[][] dp = new int[len][3];
            dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][2] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] - prices[i]);
            }
            return Math.max(Math.max(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
        }
    }
}
