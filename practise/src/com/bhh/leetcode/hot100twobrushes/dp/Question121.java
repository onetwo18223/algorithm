package com.bhh.leetcode.hot100twobrushes.dp;

/**
 * @author bhh
 * @description 买卖股票的最佳时机
 * @date Created in 2022-01-21 17:29
 * @modified By
 */
public class Question121 {
    class Solution {
        /*
        若是使用dp需要标记状态, 使用贪心是最优解
         */
        public int maxProfit(int[] nums) {
            int min = nums[0];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                } else if (nums[i] > min) {
                    max = Math.max(max, nums[i] - min);
                }
            }
            return max;
        }
    }
}
