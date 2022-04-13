package com.bhh.leetcode.four.sort;

/**
 * @author bhh
 * @description 颜色分类
 * @date Created in 2022-03-05 22:20
 * @modified By
 */
public class Question75 {
    class Solution {
        /*
        快排, 三路快排
         */
        public void sortColors(int[] nums) {
            int left = -1;
            int right = nums.length;
            for (int i = 0; i < right; i++) {
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

        private void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}
