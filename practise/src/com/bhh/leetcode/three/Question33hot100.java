package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 搜索旋转排序数组
 * @date Created in 2022-01-31 17:15
 * @modified By
 */
public class Question33hot100 {
    class Solution {
        /*
        二分搜索, 旋转的关注点在于right边界
         */
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            // 结束 left + 1 == right
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                // 5 6 7 3 4
                if (nums[mid] > nums[right]) {
                    if (target >= nums[left] && target <= nums[mid]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                // 1 2 3 4 5
                else {
                    if (target <= nums[right] && target >= nums[mid]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
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
