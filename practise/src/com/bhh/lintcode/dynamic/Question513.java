package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 完美平方
 * @date Created in 2021-12-31 19:53
 * @modified By
 */
public class Question513 {
    public class Solution {
        /*
        求最少分割成多少个完全平方数/ 最值问题/ 考虑DP/ 划分型DP
        1.状态
            dp[]用来存储前i个数值最少可以分割成多少个平方数
            最后一步
                最后分割出一个数值为i = j * j, 那么就是需要求n - i最少分割成多少个完全平方数
            子问题
                求n - i最少分割成多少个完全平方数
        2.公式转换
            dp[i] = Math.max(j * j(for(j < i)) + dp[i - j * j], dp[i])
        3.初始值和边界值
            dp[0] = 0;
        4.顺序
            正序
         */
        public int numSquares(int n) {
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            // dp[i] = Math.max(1 + dp[i - j * j](for(j < i)), dp[i])
            for (int i = 1; i < n + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j * j < i + 1; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
