package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 完全平方数
 * @date Created in 2022-01-25 12:23
 * @modified By
 */
public class Question279 {
    class Solution {
        /*
        求最值 尝试dp 序列dp
        1.状态
            dp[len + 1] 表示和为i的平方数的最少平方数数量
        2.转换公式
            dp[i] = j:for(i ~ i - j * j >= 0) | dp[j] + 1;
            dp[i] = math.min(dp[i], dp[j] + 1);
        3.初始值和边界值
            dp[0] = 1;
            dp[1] = 1;
        4.顺序
         */
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = i;
                for (int j = 1; i - j * j >= 0 ; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
