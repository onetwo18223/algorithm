package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 买卖股票的最佳时机 II
 * @date Created in 2021-12-31 18:38
 * @modified By
 */
public class Question150 {
    public class Solution {
        /*
        买卖股票系列
        第二个问题, 允许多次买卖
        遍历, 判断当天价格和前一天价格, 当天价格 - 前天价格若是正数, 则直接售出
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    sum += (prices[i] - prices[i - 1]);
                }
            }
            return sum;
        }
    }
}
