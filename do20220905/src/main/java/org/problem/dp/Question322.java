package org.problem.dp;

/**
 * 零钱兑换
 *
 * 实现：求方法，最值，能否，可以使用dp完成
 *
 */
public class Question322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int length = coins.length;
            // 返回值是要求dp[amount]，那么需要申请amount + 1的数组空间
            int[] dp = new int[amount + 1];
            int i, j;
            // 定义初始值
            // 1250 250 200 200 150 700
            dp[0] = 0;
            for (i = 1; i <= amount; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (j = 0; j < length; j++) {
                    // 当前amount大于等于硬币值
                    if (i >= coins[j]
                            // 指定amount值对应的dp数组不为空
                            && dp[i - coins[j]] != Integer.MAX_VALUE
                            // 指定amount值对应的dp数组 + 1 < 当前dp值
                            && dp[i - coins[j]] + 1 < dp[i])
                        dp[i] = dp[i - coins[j]] + 1;
                }
            }
            if (dp[amount] == Integer.MAX_VALUE)
                return -1;
            return dp[amount];
        }
    }
}
