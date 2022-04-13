package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 打家劫舍
 * @date Created in 2022-01-21 19:04
 * @modified By
 */
public class Question198 {
    class Solution {
        /*
        求最值 dp 坐标型
        1.状态
            dp[len][0] 表示不偷窃某一个元素时的最大值
            dp[len][1] 表示偷窃了某一个元素时的最大值
        2.转换公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1])
            dp[i][1] = dp[i - 1][0] + nums[i]
        3.初始值和边界值
            dp[0][0] = 0
            dp[0][1] = nums[0]
        4.顺序
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
