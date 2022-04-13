package com.bhh.leetcode.four.other;

/**
 * @author bhh
 * @description 最短无序连续子数组
 * @date Created in 2022-03-04 18:10
 * @modified By
 */
public class Question581 {
    class Solution {
        /*
        求对哪些元素进行排序后数组会变成升序
        找俩个节点,
        从前往后寻找最大值, 如果是升序,
            那么下一个元素一定是大于当前元素的, 不大于则记录为right
        从后往前寻找最小值, 如果是升序,
            那么下一个元素一定是小于当前元素的, 不小于则记录为left
         */
        public int findUnsortedSubarray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int len = nums.length;
            int right = 0, left = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] >= max) {
                    max = nums[i];
                } else {
                    right = i;
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] <= min) {
                    min = nums[i];
                } else {
                    left = i;
                }
            }
            if (right == 0 && left == 0) {
                return 0;
            }
            return right - left + 1;
        }
    }
}
