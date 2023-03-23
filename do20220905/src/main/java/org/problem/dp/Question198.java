package org.problem.dp;

/**
 * 打家劫舍
 *
 * 每个房子都有俩个选择，那么我们可以选择dp[i][0] 与 dp[i][1]
 * dp[i][0]表示 不偷
 * dp[i][1]表示 偷
 * 1.1 最后一步
 *      如果最后一个房子偷，那么前一个不偷，反之亦然
 * 1.2 子问题
 * 2 公式转换
 *      错位
 *      // 不偷
 *      dp[i][0] = Max(dp[i - 1][1], dp[i - 1][0]) + nums[i - 1]
 *      // 偷
 *      dp[i][1] = dp[i - 1][0]
 * 3 初始值和边界值
 * dp[0][0] = 0, dp[0][1] = 0
 * 4 顺序
 */
public class Question198 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int length = nums.length;
            int[][] dp = new int[length + 1][2];
            for (int i = 1; i <= length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + nums[i - 1];
            }
            return Math.max(dp[length][0], dp[length][1]);
        }
    }
}
