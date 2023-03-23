package org.problem.dp;

/**
 * 最长递增子序列
 *
 * 实现：
 * 1.1 定义
 *      dp[] 定义为 当前元素最长递增子序列长度
 * 1.2 最后一步
 *      最后一个元素和前面元素进行遍历对比，若是大于则，dp[i] = dp[j] + 1;
 * 2 转换公式
 *      forj:(0 ~ i)
 *      dp[i] = if(nums[i] > nums[j]) dp[j] + 1;
 * 3 初始值和边界值
 *      dp[0] = 1;
 * 4 顺序
 */
public class Question300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            int[] dp = new int[len];
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    dp[i] = nums[i] > nums[j]
                            ? Math.max(dp[i], dp[j] + 1) : dp[i];
                }
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }
}
