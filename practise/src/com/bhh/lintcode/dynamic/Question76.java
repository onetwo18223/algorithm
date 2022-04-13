package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 最长上升子序列
 * @date Created in 2021-12-31 19:33
 * @modified By
 */
public class Question76 {
    public class Solution {
        /*
        最长子序列/ 最长子序列型DP
        1.状态
            dp[i]:对于元素i上升队列的长度为dp[i]
            最后一步 : 最后一个元素对比其他元素, 是否有其相对来说较小的元素, 若是有则dp[i] = dp[j] + 1
            子问题 : 是否有小于该元素的元素存在
        2.公式转换
            dp[i] = dp[j] + 1 | nums[i] > nums[j]
        3.初始值和边界值
            dp[i] = 1;
        4.顺序
            正序
         */
        public int longestIncreasingSubsequence(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int[] dp = new int[len];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }
    }
}
