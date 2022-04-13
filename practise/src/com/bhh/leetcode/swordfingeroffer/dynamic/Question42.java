package com.bhh.leetcode.swordfingeroffer.dynamic;

import java.util.Arrays;

/**
 * @author bhh
 * @description 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @date Created in 2021-10-09 19:23
 * @modified By
 */
public class Question42 {
    /*
    错误原因 : 虽然可以通过递归 + 记忆化搜索可以实现部分
    但是因为存储信息的数据memo中会存储 负数, 0, 正数,
    所以递归结束条件返回0, 又或者 if(memo[index] != 0)都不可以使用
    递归被破坏, 可以直接使用递推
     */
    class SolutionError {
        private int[] memo;
        private int max;

        public int maxSubArray(int[] nums) {
            int n = nums.length;
            memo = new int[n];
            Arrays.fill(memo, Integer.MIN_VALUE);
            re(nums, n - 1);
            return max;
        }

        private int re(int[] nums, int index) {
            if (index >= nums.length || index < 0) {
                return Integer.MIN_VALUE;
            }
            if (memo[index] != Integer.MIN_VALUE) {
                return memo[index];
            }
            memo[index] = Math.max(nums[index],
                    nums[index] + re(nums, index - 1));
            max = Math.max(max, memo[index]);
            return memo[index];
        }
    }

    class Solution {
        private int[] memo;
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            memo = new int[length];
            memo[0] = nums[0];
            int res = nums[0];
            for (int i = 1; i < length; i++) {
                memo[i] = Math.max(nums[i] + memo[i - 1], nums[i]);
                res = Math.max(res, memo[i]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question42().new Solution().maxSubArray(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        }));
    }
}
