package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 除自身以外数组的乘积
 * @date Created in 2022-01-29 22:14
 * @modified By
 */
public class Question238hot100 {
    class Solution {
        /*
        俩次乘积可完成
         */
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int[] res = new int[nums.length];
            res[0] = 1;
            // 沿对角线计算对角线下的结果
            for (int i = 1; i < nums.length; i++) {
                res[i] = nums[i - 1] * res[i - 1];
            }
            // 沿对角线计算对角线上的结果
            int tmp = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                tmp *= nums[i + 1];
                res[i] *= tmp;
            }
            return res;
        }
    }
}
