package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 最大子数组和
 * @date Created in 2021-12-21 14:36
 * @modified By
 */
public class Question53 {
    class Solution {
        /*
        前缀和, 最大前缀和减去为负的前缀和 生成最大值
         */
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int res = Integer.MIN_VALUE;

            int preSum = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                min = Math.min(preSum, min);
                max = Math.max(preSum, max);
                res = Math.max(res, Math.max(max, max - min));
            }
            return res;
        }

        /*
        求最大和/ 最值问题/ 考虑DP/ 序列型DP
        1.状态
            最后一步 : 获取len - 1元素值, 并获取前len - 1的连续子数组最大和
            子问题 : i元素前的最大连续子数组和
        2.转换公式
            dp[i] = max(dp[i - 1] + nums[i - 1], nums[i - 1])
        3.初始值和边界值
            dp[0] = 0;
        4.顺序
         */
        public int maxSubArrayDP(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            int[] dp = new int[len + 1];
            dp[0] = 0;
            int res = Integer.MIN_VALUE;
            for (int i = 1; i < len + 1; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        /*
        这道题更好的解法
         */
        public int maxSubArrayEasy(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int res = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                res = Math.max(res, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return res;
        }
    }
}
