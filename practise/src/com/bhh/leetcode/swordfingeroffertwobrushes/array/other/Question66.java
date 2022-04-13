package com.bhh.leetcode.swordfingeroffertwobrushes.array.other;

/**
 * @author bhh
 * @description 构建乘积数组
 * @date Created in 2022-01-12 19:16
 * @modified By
 */
public class Question66 {
    class Solution {
        /*
        对于这道题目来说有一个比较好的方法是使用俩次遍历乘积
         */
        public int[] constructArr(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
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
