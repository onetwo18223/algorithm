package com.bhh.lintcode.twopointr.facing.partition;

/**
 * @author bhh
 * @description 颜色分类
 * @date Created in 2021-12-01 20:13
 * @modified By
 */
public class Question148 {
    public class Solution {
        /*
        题目要求使用O(n)的复杂度完成, 无法直接使用排序完成
        可以
            快排或者HashMap完成
            快排需要使用三路快排
         */
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0){
                return;
            }
            int start = 0;
            int end = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    swap(nums, i, start++);
                } else if (nums[i] == 2) {
                    swap(nums, i, end--);
                }
            }
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}
