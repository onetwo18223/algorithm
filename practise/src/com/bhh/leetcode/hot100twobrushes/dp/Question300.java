package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 最长递增子序列
 * @date Created in 2022-01-21 15:19
 * @modified By
 */
public class Question300 {
    class Solution {
        /*
        求最长子序列, 求最值, 尝试dp, 坐标型dp
        1.状态
            dp[len] 定义为前i个元素的最长递增子序列
        2.转换公式
            dp[i] = Math.max(dp[j] + 1, dp[i]);
        3.初始值到边界值
            dp[0] = 1
        4.顺序
         */
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
