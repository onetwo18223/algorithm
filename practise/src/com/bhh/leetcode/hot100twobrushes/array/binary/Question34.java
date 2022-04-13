package com.bhh.leetcode.hot100twobrushes.array.binary;

/**
 * @author bhh
 * @description 在排序数组中查找元素的第一个和最后一个位置
 * @date Created in 2022-01-21 17:09
 * @modified By
 */
public class Question34 {
    class Solution {
        /*
        查找到第一个位置后向后遍历获取最后一个位置
         */
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int left = 0, right = nums.length - 1;
            // 结束 left + 1 == right
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            int start;
            if (nums[left] == target) {
                start = left;
            } else if (nums[right] == target) {
                start = right;
            } else {
                return new int[]{-1, -1};
            }
            int end = start;
            while (end < nums.length && nums[end] == target) {
                end++;
            }
            return new int[]{start, end - 1};
        }
    }
}
