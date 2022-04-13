package com.bhh.leetcode.hot100twobrushes.array;

/**
 * @author bhh
 * @description 最大子数组和
 * @date Created in 2022-01-21 13:03
 * @modified By
 */
public class Question53 {
    class Solution {
        /*
        求和, 当和小于0是重置, 取最大值
         */
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }
}
