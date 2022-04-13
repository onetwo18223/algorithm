package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 零钱兑换
 * @date Created in 2022-01-21 19:15
 * @modified By
 */
public class Question322 {
    class Solution {
        /*
        第一个想到是bfs, 最短路劲
        第二个是动归 序列型dp
        1.状态
            dp[amount] 表示生成amount最少需要多少个硬币
        2.转换公式
            dp[i] = Math.min(dp[i], for coins)
        3.初始值和边界值
            dp[0] = 0;
        4.顺序
            正序
         */
        public int coinChange(int[] nums, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i < amount + 1; i++) {
                // 因为转换公式使用的是min函数, 所以初始化为最大
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < nums.length; j++) {
                    dp[i] = Math.min(dp[i],
                            // 这里不可以越界, 也不可以让 dp[i - nums[i]] != Integer.MAX_VALUE
                            i - nums[j] >= 0 && dp[i - nums[i]] != Integer.MAX_VALUE
                                    ? dp[i - nums[j]] + 1 : Integer.MAX_VALUE);
                }
            }
            // 如果返回值为Integer.MAX_VALUE表示生成不了该价值, 所以返回-1
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
