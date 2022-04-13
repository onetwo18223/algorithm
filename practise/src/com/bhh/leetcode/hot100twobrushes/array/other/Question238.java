package com.bhh.leetcode.hot100twobrushes.array.other;

/**
 * @author bhh
 * @description 除自身以外数组的乘积
 * @date Created in 2022-01-22 17:27
 * @modified By
 */
public class Question238 {
    class Solution {
        /*
        不使用除法, 沿对角线俩次乘法
         */
        public int[] productExceptSelf(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[]{};
            }
            int len = nums.length;
            int[] res = new int[len];
            res[0] = 1;
            for (int i = 1; i < len; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }

            int tmp = 1;
            for (int i = len - 2; i >= 0; i--) {
                tmp *= nums[i + 1];
                res[i] *= tmp;
            }
            return res;
        }
    }
}
