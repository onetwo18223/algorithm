package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 多数元素
 * @date Created in 2022-02-23 17:07
 * @modified By
 */
public class Question169 {
    class Solution {
        /*
        摩尔投票法
         */
        public int majorityElement(int[] nums) {
            int tmp = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (tmp != nums[i]) {
                    count--;
                    if (count == 0) {
                        tmp = nums[i];
                        count = 1;
                    }
                } else {
                    count++;
                }
            }
            return tmp;
        }
    }
}
