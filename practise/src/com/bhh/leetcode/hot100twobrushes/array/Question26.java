package com.bhh.leetcode.hot100twobrushes.array;

/**
 * @author bhh
 * @description 删除有序数组中的重复项
 * @date Created in 2022-01-27 12:07
 * @modified By
 */
public class Question26 {
    class Solution {
        /*
        这道题其实就是要求返回nums数组中有效个数
        要求有效个数是没有重复元素
        快慢数指针
         */
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0, right = 0;
            while (right < nums.length) {
                if (nums[left] == nums[right]) {
                    right++;
                } else {
                    left++;
                    nums[left] = nums[right];
                    right++;
                }
            }
            return left + 1;
        }
    }
}
