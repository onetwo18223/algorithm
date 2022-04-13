package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 乘积最大子数组
 * @date Created in 2022-01-29 23:02
 * @modified By
 */
public class Question152hot100 {
    class Solution {
        /*
        需要俩个dp, 一个是最大值, 一个是最小值
        坐标型
         */
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int[] minDp = new int[len];
            minDp[0] = nums[0];
            int[] maxDp = new int[len];
            maxDp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < len; i++) {
                maxDp[i] = Math.max(Math.max(nums[i], maxDp[i - 1] * nums[i]), minDp[i - 1] * nums[i]);
                minDp[i] = Math.min(Math.min(nums[i], maxDp[i - 1] * nums[i]), minDp[i - 1] * nums[i]);
                max = Math.max(max, maxDp[i]);
            }
            return max;
        }
    }
}
