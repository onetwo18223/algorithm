package com.bhh.leetcode.four.dp;

/**
 * @author bhh
 * @description 完全平方数
 * @date Created in 2022-03-04 12:18
 * @modified By
 */
public class Question279 {
    class Solution {
        /*
        求最小值, 尝试dp, 坐标型dp
        1.状态
            最后一步
            子问题
        2.公式转换
            dp[i] = for(j : 1 ~ i - 1) | dp[i - j * j] + 1;
        3.初始值和边界值
        4.顺序
         */
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
}
