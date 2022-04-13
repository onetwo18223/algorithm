package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description  爬楼梯
 * @date Created in 2022-02-22 21:45
 * @modified By
 */
public class Question70 {
    class Solution {
        /*
        动态规划
        1.状态
        2.转换公式
        3.初始值和边界值
        4.顺序
         */
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
