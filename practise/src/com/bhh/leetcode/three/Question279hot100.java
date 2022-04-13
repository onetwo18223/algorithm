package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 完全平方数
 * @date Created in 2022-01-29 23:28
 * @modified By
 */
public class Question279hot100 {
    class Solution {
        /*
        序列性dp
         */
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; i - j * j >= 0; j++) {
                    if (dp[i - j * j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
