package org.problem.dp;

/**
 * 买卖股票的最佳时机II
 *
 * 实现
 * dp[i][0] 买入
 * dp[i][1] 卖出
 * dp[i][2] 不买也不卖
 * 1.1 最后一步
 *      买入利润 = max(dp[i - 1][1], dp[i - 1][2]) - prices[i]
 *      卖出利润 = max(dp[i - 1][0], dp[i - 1][2]) + prices[i]
 *      不买也不卖利润 =  max(dp[0], dp[1])
 * 1.2 子问题
 * 2 转换公式
 *      dp[i][0] = max(dp[i - 1][1], dp[i - 1][2]) - prices[i - 1]
 *      dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + prices[i - 1]
 *      dp[i][2] = max(dp[0], dp[1])
 * 3 初始值和边界值
 *      dp[0][] = 0
 * 4 顺序
 *
 *
 * 不持有股票 dp[i][0]
 * 持有股票 dp[i][1]
 * 1.1 最后一步
 *      持有股票 = 前面不持有股票 - 买股票的钱 ，或者，持有股票
 *      不持有股票 = 前面持有股票 + 卖股票的钱 ，或者，不持有股票
 * 1.2 子问题
 * 2 状态转换
 *      dp[i][0] = max(dp[i - 1][1] - prices[i], dp[i - 1][0])
 *      dp[i][1] = max(dp[i - 1][0] + prices[i], dp[i - 1][1])
 * 3 初始值和边界值
 *      dp[0][0] = 0;
 *      dp[0][1] = -prices[0];
 * 4 顺序
 */
public class Question122 {
    /**
     * dp定义错误
     */
    class SolutionError {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int len = prices.length;
            int[][] dp = new int[len][3];
            dp[0][0] = -prices[0];
            dp[0][1] = prices[0];
            dp[0][2] = 0;
            for (int i = 1; i < len; i++) {
                // 买入
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) - prices[i];
                // 卖出
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + prices[i];
                // 不买也不卖
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
            return Math.max(Math.max(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
        }
    }

    class Solution{
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int len = prices.length;
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < len; i++) {
                // 不持有股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 持有股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question122()
                .new Solution()
                .maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
