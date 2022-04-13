package com.bhh.leetcode.hot100twobrushes.array.binary;

/**
 * @author bhh
 * @description 搜索旋转排序数组
 * @date Created in 2022-01-21 15:44
 * @modified By
 */
public class Question33 {
    class Solution {
        /*
        二分搜索
        取mid, 判断mid在哪个范围
        0 0 0 0 0 1 0
        1 0 0 0 0 0 0
         */
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            // 结束 : left + 1 == right
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else if (nums[mid] < nums[right]) {
                    if (target >= nums[mid] && target <= nums[right]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                } else {
                    right--;
                }
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            return -1;
        }
    }
}
