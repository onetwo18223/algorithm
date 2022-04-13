package com.bhh.leetcode.swordfingeroffertwobrushes.array;

/**
 * @author bhh
 * @description 连续子数组的最大和
 * @date Created in 2022-01-11 21:46
 * @modified By
 */
public class Question42 {
    class Solution {
        /*
        遍历, 取和, 若是和小于0, 则重置
         */
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length ==0) {
                return 0;
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(max, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }
}
