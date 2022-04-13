package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 零钱
 * @date Created in 2022-01-02 22:19
 * @modified By
 */
public class Question322 {
    class Solution {
        /*
        求最值/考虑DP/序列型DP
        1.状态
            dp[i] 定义为凑成金额i需要的最少硬币数
        2.转换公式
            for(j in coins)
            dp[i] = min(dp[i], dp[i - j] + 1);
        3.初始值
            dp[0] = 0;
        4.顺序
            正序
         */
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i < amount + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0 &&
                            dp[i - coins[j]] < Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
