package com.bhh.leetcode.hot100twobrushes.array.sort;

/**
 * @author bhh
 * @description 颜色分类
 * @date Created in 2022-01-22 16:53
 * @modified By
 */
public class Question75 {
    class Solution {
        /*
        快排, 这道题双路快排无法解决
        三路快排
         */
        public void sortColors(int[] nums) {
            int left = -1, right = nums.length;
            for (int i = left + 1; i < right; i++) {
                if (nums[i] == 0) {
                    left++;
                    swap(nums, i, left);
                } else if (nums[i] == 2) {
                    right--;
                    swap(nums, i, right);
                    i--;
                }
            }
        }

        private void swap(int[] nums, int index, int index2) {
            int tmp = nums[index];
            nums[index] = nums[index2];
            nums[index2] = tmp;
        }
    }
}
