package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 剪绳子
 * @date Created in 2022-01-29 9:28
 * @modified By
 */
public class Question14_1sword {
    class Solution {
        /*
        求最值 尝试dp 序列型dp
        1.状态
            dp[n + 1] 表示长度为n的绳子分段的最大乘积结果
        2.转换公式
            dp[i] = j : for(1 ~ i) | max(j * (i - j),  j * dp[i - j], dp[i])
        3.初始值和边界值
            dp[2] = 1;
            dp[1] = 1;
        4.顺序
            正序
         */
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i],
                            Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }
}
