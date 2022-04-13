package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 最短无序连续子数组
 * @date Created in 2022-01-28 20:33
 * @modified By
 */
public class Question581hot100 {
    class Solution {
        /*
        很离谱的一道题
         */
        public int findUnsortedSubarray(int[] nums) {
            int max = nums[0];
            int min = nums[nums.length - 1];
            int left = 0, right = 0;
            for (int i = 1; i < nums.length; i++) {
                if (max <= nums[i]) {
                    max = nums[i];
                } else {
                    right = i;
                }
            }
            for (int i = nums.length - 2; i >= 0; i--) {
                if (min >= nums[i]) {
                    min = nums[i];
                } else {
                    left = i;
                }
            }
            if (left == 0 && right == 0) {
                return 0;
            }
            return right - left + 1;
        }
    }
}
