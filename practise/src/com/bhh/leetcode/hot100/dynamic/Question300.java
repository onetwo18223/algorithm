package com.bhh.leetcode.hot100.dynamic;

/**
 * @author bhh
 * @description 最长递增子序列
 * @date Created in 2022-01-02 11:59
 * @modified By
 */
public class Question300 {
    class Solution {
        /*
        最长序列经典题目/ 最长序列型DP
        1.状态
            最后一步 对于元素len - 1而言, 因为是不需要连续子序列, 所以要再遍历前len - 1元素, 判断比len - 1元素小的元素
            dp[i]定义 元素前i个最长子序列长度
        2.转换公式
            j:for(0 ~ i - 1)
            dp[i] = dp[j] + 1|nums[i - 1] > nums[j]
        3.初始值和边界值
            dp[0] = 0;
        4.顺序
            正序
         */
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int[] dp = new int[len + 1];
            dp[0] = 1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len + 1; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i - 1] > nums[j]) {
                        dp[i] = Math.max(dp[j + 1] + 1, dp[i]);
                    }
                    max = Math.max(dp[i], max);
                }
            }
            return max;
        }
    }
}
