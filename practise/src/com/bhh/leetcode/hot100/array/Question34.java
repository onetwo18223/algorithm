package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 在排序数组中查找元素的第一个和最后一个位置
 * @date Created in 2021-12-21 11:15
 * @modified By
 */
public class Question34 {
    class Solution {
        /*
        根据二分查找, 查找target的第一个索引和最后一个索引
         */
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int left = 0, right = nums.length - 1;
            return new int[]{getLower(nums, target, left, right),
                    getUpper(nums, target, left, right)};
        }

        private int getUpper(int[] nums, int target, int left, int right) {
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid;
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private int getLower(int[] nums, int target, int left, int right) {
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
