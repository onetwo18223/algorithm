package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description  最大子数组和
 * @date Created in 2022-01-30 10:49
 * @modified By
 */
public class Question53hot100 {
    class Solution {
        /*
        求和, 当和小于0时, 重置
         */
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
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
