package com.bhh.leetcode.four.dp;

/**
 * @author bhh
 * @description 最长递增子序列
 * @date Created in 2022-03-04 11:11
 * @modified By
 */
public class Question300 {
    class Solution {
        /*
        求最值, dp, 坐标型dp
        1.状态
        2.公式转换
            dp[i] = Math.max((for(j 到 i) | dp[j]) if(nums[i] > nums[j]) ,
                dp[i])
        3.初始值和边界值
        4.顺序
         */
        public int lengthOfLIS(int[] nums) {
            int max = 0;
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] > dp[i]) {
                            dp[i] = dp[j] + 1;
                        }
                    } else if (nums[i] == nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
