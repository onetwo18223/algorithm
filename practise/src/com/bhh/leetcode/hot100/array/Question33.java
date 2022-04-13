package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 搜索旋转排序数组
 * @date Created in 2021-12-21 10:27
 * @modified By
 */
public class Question33 {
    class Solution {
        /*
        数组 + 有序 + 目标值 = 二分
        4,5,6,7,0,1,2
        0 1 2 4 5 6 7
         */
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            // 结尾条件 : left + 1 == right
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                // mid在第一阶段
                if (nums[mid] > nums[right]){
                    // mid在第一阶段就证明 从left到mid是递增的
                    if (nums[left] <= target && target <= nums[mid]){
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                // mid在第二阶段
                else {
                    // mid在第二阶段就证明 从mid到right是递增的
                    if (nums[mid] <= target && target <= nums[right]){
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
