package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 颜色分类
 * @date Created in 2022-02-02 15:11
 * @modified By
 */
public class Question75hot100 {
    class Solution {
        /*
        经典快排
        三路快排直接解决
         */
        public void sortColors(int[] nums) {
            // 注意三路快排的起始点, 也就是这俩个指针的意义所在
            int left = -1;
            int right = nums.length;
            for (int i = 0; i < right; i++) {
                if (nums[i] == 0) {
                    left++;
                    swap(nums, left, i);
                }
                // 与后方进行交换
                else if (nums[i] == 2) {
                    right--;
                    swap(nums, i, right);
                    // 与right交换时需要注意交换的元素若是没有被遍历
                    // 则需要重新处理该元素
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
