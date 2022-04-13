package com.bhh.leetcode.swordfingeroffertwobrushes.array.binary;

/**
 * @author bhh
 * @description 旋转数组的最小数字
 * @date Created in 2022-01-11 22:05
 * @modified By
 */
public class Question11 {
    class Solution {
        /*
        二分
        有序 + target + 数组
        寻找nums[right]充当参照数
         */
        public int minArray(int[] nums) {
            int left = 0, right = nums.length - 1;
            // 结束条件为 left + 1 == right
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                // 中间值大于参照值, 最小值在右
                if (nums[mid] > nums[right]) {
                    left = mid;
                }
                // 中间值小于参照值, 最小值在左
                else if (nums[mid] < nums[right]) {
                    right = mid;
                }
                // 相等的情况, 有多种, 所以递减遍历
                else {
                    right--;
                }
            }
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            return nums[right];
        }
    }
}
