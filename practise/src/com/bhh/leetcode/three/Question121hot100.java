package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 买卖股票的最佳时机
 * @date Created in 2022-01-30 11:02
 * @modified By
 */
public class Question121hot100 {
    class Solution {
        /*
        取得最大最小值相减
         */
        public int maxProfit(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                } else {
                    max = Math.max(max, nums[i] - min);
                }
            }
            return max;
        }
    }
}
