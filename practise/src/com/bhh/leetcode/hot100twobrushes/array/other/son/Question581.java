package com.bhh.leetcode.hot100twobrushes.array.other.son;

/**
 * @author bhh
 * @description 最短无序连续子数组
 * @date Created in 2022-01-22 20:40
 * @modified By
 */
public class Question581 {
    class Solution {
        /*
        方法一 : 排序后比对, O(nlogn)
        方法二 : 俩次遍历,
            一次依靠求最大值获取右边界, 若是从左往右没有大于max(从nums[0]开始), 则记录为right
            再一次同理获取左边界
         */
        public int findUnsortedSubarray(int[] nums) {
            int max = nums[0];
            int len = nums.length;
            int min = nums[len - 1];
            int left = 0, right = len - 1;
            for (int i = 0; i < len; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                } else {
                    left = i;
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] < min) {
                    min = nums[i];
                } else {
                    right = i;
                }
            }
            if (left == 0 && right == len - 1) {
                return 0;
            }
            return left - right + 1;
        }
    }
}
