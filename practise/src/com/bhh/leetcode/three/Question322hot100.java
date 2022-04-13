package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 零钱兑换
 * @date Created in 2022-01-29 11:46
 * @modified By
 */
public class Question322hot100 {
    class Solution {
        /*
        求最值 尝试dp 序列型dp
        1.状态
            dp[len + 1] 表示生成前i个元素需要的最少硬币数量
        2.转换公式
            dp[i] = min(dp[i], dp[i - nums[j]] + 1 | j : for(0 ~ coins.length))
        3.初始值和边界值
            dp[0] = 0;
        4.顺序
            正序
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
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
