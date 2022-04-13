package com.bhh.leetcode.swordfingeroffertwobrushes.array.dp;

/**
 * @author bhh
 * @description  斐波那契数列
 * @date Created in 2022-01-19 13:47
 * @modified By
 */
public class Question10_1 {
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
            return dp[n];
        }
    }
}
