package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description  买卖股票的最佳时机含手续费
 * @date Created in 2022-01-03 9:58
 * @modified By
 */
public class Question714 {
    class Solution {
        /*
        股票问题扩展第二题
        十分类似于Question122, 即股票问题第二题
        1.状态
            定义dp[len][2]
            dp[i][0] 表示持股最大利润
            dp[i][1] 表示不持股最大利润
        2.转换公式
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        3.初始值和边界值
            dp[0][0] = -prices[0]
        4.顺序
            正序
         */
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int len = prices.length;
            int[][] dp = new int[len][2];
            dp[0][0] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
            }
            return dp[len - 1][0];
        }
    }
}
