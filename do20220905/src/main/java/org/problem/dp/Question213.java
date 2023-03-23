package org.problem.dp;

import java.util.Arrays;

/**
 * 打家劫舍II
 *
 * 和 Question198打家劫舍I 类似，但是本题是循环
 * 需要手动判断
 * 当 0 ~ length - 1 存在时 可获得的最高金额
 * 当 1 ~ length 存在时 可获得的最高金额
 *
 * 1.1 最后一步
 * 1.2 子问题
 * 2 转换公式
 * 3 初始值和边界值
 * 4 顺序
 */
public class Question213 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            // copy的数组一个没有头结点，一个没有尾节点
            // 优点：可以手动实现题目要求
            // 缺点：如果只有一个元素，那么俩个数组都不会包含这单个元素，不能正常处理需求
            if (nums.length == 1) return nums[0];
            return Math.max(doRob(Arrays.copyOfRange(nums, 0, nums.length - 1))
                    ,doRob(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        private int doRob(int[] nums) {
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
