package com.bhh.leetcode.four.dp;

/**
 * @author bhh
 * @description 零钱兑换
 * @date Created in 2022-03-04 12:36
 * @modified By
 */
public class Question322 {
    class Solution {
        /*
        求最少值, 序列性dp
        1.状态
            最后一步
            子问题
        2.转换公式
            dp[i] = Math.min(for(j : 0 ~ coins.length()) |
                dp[i - coins[j]] + 1)
        3.初始值和边界值
        4.顺序
         */
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            for (int i = 1; i < amount + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] < 0 ||
                            dp[i - coins[j]] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
