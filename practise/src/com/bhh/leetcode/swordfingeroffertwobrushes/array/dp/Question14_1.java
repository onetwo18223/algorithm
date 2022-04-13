package com.bhh.leetcode.swordfingeroffertwobrushes.array.dp;

/**
 * @author bhh
 * @description 剪绳子
 * @date Created in 2022-01-19 16:07
 * @modified By
 */
public class Question14_1 {
    class Solution {
        /*
        求最值/尝试dp/序列性dp
        1.状态
            最后一步 最后一段从2开始到绳子结尾遍历尝试所有结果, 获取最大值
            dp[len + 1] 定义为第i个元素剪绳子的最大值
        2.转换公式
            dp[i] = max(j * (i - j), j * dp[i - j])|for 2~i
        3.初始值和边界值
            dp[2] = 1
        4.顺序
         */
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                for (int j = 2; j < i - 1; j++) {
                    // 循环获取最大值
                    dp[i] = Math.max(dp[i],
                            // 剪成俩段和剪成多段
                            Math.max(j * (i - j), j * dp[i - j]) );
                }
            }
            return dp[n];
        }
    }
}
