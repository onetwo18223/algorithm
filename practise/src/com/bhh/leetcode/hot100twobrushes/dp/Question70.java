package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 爬楼梯
 * @date Created in 2022-01-24 19:39
 * @modified By
 */
public class Question70 {
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            return dp[n];
        }
    }
}
