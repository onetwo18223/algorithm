package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 买卖股票的最佳时机 II
 * @date Created in 2022-01-03 8:52
 * @modified By
 */
public class Question122 {
    class Solution {
        /*
        股票系列问题, 第二题
        直接比较前后元素的大小值, 若是后一个元素较大则获取差值
         */
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }

        /*
        DP做法
         */
        public int maxProfitDP(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int len = prices.length;
            int[][] dp = new int[len][2];
            dp[0][0] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }
            return dp[len - 1][0];
        }
    }
}
