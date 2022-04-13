package com.bhh.leetcode.four.dp;

/**
 * @author bhh
 * @description 乘积最大子数组
 * @date Created in 2022-03-04 11:50
 * @modified By
 */
public class Question152 {
    class Solution {
        /*
        求最大值, 坐标型dp
        1.状态
            最后一步 最后一个元素的最大值, 可能是前一个最小值 * 当前元素 或者是
                前一个最大值 * 当前元素
        2.公式转换
            maxDp[i] = Math.max(maxDp[i], maxDp[i - 1] * nums[i])
            minDp[i] = Math.min(minDp[i], minDp[i - 1] * nums[i])
        3.初始值和边界值
        4.顺序
         */
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int len = nums.length;
            int[] maxDp = new int[len];
            int[] minDp = new int[len];
            maxDp[0] = minDp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                maxDp[i] = Math.max(nums[i],
                        Math.max(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i]));
                minDp[i] = Math.min(nums[i],
                        Math.min(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i]));
                max = Math.max(max, maxDp[i]);
            }
            return max;
        }
    }
}
