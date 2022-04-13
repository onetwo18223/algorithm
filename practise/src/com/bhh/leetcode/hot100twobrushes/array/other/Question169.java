package com.bhh.leetcode.hot100twobrushes.array.other;

/**
 * @author bhh
 * @description 多数元素
 * @date Created in 2022-01-21 17:22
 * @modified By
 */
public class Question169 {
    class Solution {
        /*
        摩尔投票法
         */
        public int majorityElement(int[] nums) {
            int res = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                // 不等于则count--;
                if (res != nums[i]) {
                    count--;
                } else {
                    count++;
                }
                // 次数为0则换
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                }
            }
            return res;
        }
    }
}
