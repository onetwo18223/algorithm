package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 买卖股票的最佳时机
 * @date Created in 2021-12-21 18:20
 * @modified By
 */
public class Question121 {
    class Solution {
        /*
        关于买卖股票其实是需要动态规划来解或许会更好
        买卖股票一系列的题目优解是动态规划
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i] - min);
            }
            return max;
        }
    }
}
