package com.bhh.leetcode.four.other;

/**
 * @author bhh
 * @description 除自身以外数组的乘积
 * @date Created in 2022-03-04 16:43
 * @modified By
 */
public class Question238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] res = new int[nums.length];
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
