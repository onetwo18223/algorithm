package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 买卖股票的最佳时机
 * @date Created in 2021-12-31 18:14
 * @modified By
 */
public class Question149 {
    public class Solution {
        /*
        买卖股票系列问题
        第一个问题, 只允许买卖一次的情况
        遍历prices, 获取当前最小值, 每遍历到一个元素使用该元素 - 最小值,
            记录最大差值
         */
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                    continue;
                }
                res =  Math.max(res, prices[i] - min);
            }
            return res == Integer.MIN_VALUE ? 0 : res;
        }
    }
}
