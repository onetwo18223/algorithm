package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 打家劫舍
 * @date Created in 2022-01-29 23:19
 * @modified By
 */
public class Question198hot100 {
    class Solution {
        /*
        求最大值 尝试dp 坐标型dp
        dp[i][0] 表示第i个房子没有偷
        dp[i][1] 表示第i个房子偷了
         */
        public int rob(int[] nums) {
            int len = nums.length;
            int[][] dp = new int[len][2];
            dp[0][0] = 0;
            dp[0][1] = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }
    }
}
