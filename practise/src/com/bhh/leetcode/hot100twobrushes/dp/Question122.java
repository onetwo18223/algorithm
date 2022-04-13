package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 买卖股票的最佳时机 II
 * @date Created in 2022-01-27 14:31
 * @modified By
 */
public class Question122 {
    class Solution {
        /*
        可以按照dp实现, 但是贪心可能更好
         */
        public int maxProfit(int[] prices) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        }
    }
}
