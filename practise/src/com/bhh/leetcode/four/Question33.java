package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 搜索旋转排序数组
 * @date Created in 2022-02-23 17:59
 * @modified By
 */
public class Question33 {
    class Solution {
        /*
        二分法查找
         */
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            //  结束时 left + 1 == right
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                // 中间元素大于尾部元素
                if (nums[mid] > nums[right]) {
                    // 这时候从left到right是单调递增的
                    // 在这个范围时, 你就可以缩小right
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid;
                    }
                    // 否则是在另外的范围
                    else {
                        left = mid;
                    }
                }
                // 中间元素小于尾部元素
                else if (nums[mid] < nums[right]) {
                    // 这时候从mid到right是单调递增的
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                // 中间元素等于尾部元素
                else {
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
