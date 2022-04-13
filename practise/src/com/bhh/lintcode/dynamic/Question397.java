package com.bhh.lintcode.dynamic;

/**
 * @author bhh
 * @description 最长上升连续子序列
 * @date Created in 2021-12-31 18:54
 * @modified By
 */
public class Question397 {
    public class Solution {
        /*
        双指针/ 动归
        DP
        最长子序列/ 最长子序列型DP
        1.状态
            dp[]定义存储从小到大连续子序列长度
            最后一步
                情况1 : 如果A[i]>A[i - 1] 则dp[i - 1] + 1
                情况2 : 否则情况 = dp[i - 1]
        2.转换公式
        3.初始值和边界值
            dp[0] = 1;
        4.顺序
            正序
         */
        public int longestIncreasingContinuousSubsequence(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int res = dynamic(nums);
            nums = reverse(nums);
            return Math.max(res, dynamic(nums));
        }

        // 反转数组
        private int[] reverse(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
            return nums;
        }

        // 实现通过dp获取最长子序列
        private int dynamic(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = 1;
            int max = dp[0];
            for (int i = 1; i < len; i++) {
                dp[i] = 1;
                if (nums[i] > nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                }
                if (max < dp[i]) {
                    max = dp[i];
                }
            }
            return max;
        }

        // 不使用DP
        public int longestIncreasingContinuousSubsequenceNoDP(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int res = fun(nums);
            nums = reverse(nums);
            return Math.max(res, fun(nums));
        }

        private int fun(int[] nums) {
            int num = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    num++;
                    continue;
                }
                num = 1;
            }
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question397().new Solution().longestIncreasingContinuousSubsequenceNoDP(new int[]{
                5, 4, 2, 1, 3
        }));
    }
}
