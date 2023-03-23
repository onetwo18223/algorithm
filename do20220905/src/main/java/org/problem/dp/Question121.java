package org.problem.dp;

/**
 * 买卖股票的最佳时机
 *
 * 1.1 最后一步
 *      dp[i]用来记录最大利润
 *      需要记录min最小值，然后对比之前利润大还是该次出售股票的利润大
 * 1.2 子问题
 * 2 转换公式
 *      min = min(min, prices[i])
 *      dp[i] = max(dp[i - 1], prices[i] - min);
 * 3 初始值和边界值
 *      初始值 = 0
 * 4 顺序
 */
public class Question121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int[] dp = new int[prices.length];
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min)
                    min = prices[i];
                dp[i] = Math.max(dp[i - 1], prices[i] - min);
            }
            return dp[prices.length - 1];
        }
    }
}
