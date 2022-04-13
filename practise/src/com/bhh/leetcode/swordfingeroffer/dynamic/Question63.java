package com.bhh.leetcode.swordfingeroffer.dynamic;

/**
 * @author bhh
 * @description 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @date Created in 2021-10-10 12:07
 * @modified By
 */
public class Question63 {
    class Solution {
        /*
        实现原理 : 遍历集合, 选取最小的股票进行购买
        继续遍历, 选取最大的出售价格

        收获 : 这个
         */
        public int maxProfit(int[] prices) {
            int buy = Integer.MAX_VALUE;
            int sell = 0;
            for (int i = 0; i < prices.length; i++) {
                buy = Math.min(buy, prices[i]);
                sell = Math.max(sell, prices[i] - buy);
            }
            return sell;
        }
    }
}
