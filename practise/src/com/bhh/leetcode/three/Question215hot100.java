package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 数组中的第K个最大元素
 * @date Created in 2022-01-29 22:22
 * @modified By
 */
public class Question215hot100 {
    class Solution {
        /*
        经典topk问题
        方法一 : 使用堆
        方法二 : 使用快排
         */
        // 快排
        int k;
        public int findKthLargest(int[] nums, int k) {
            this.k = nums.length - k;
            return quickSelect(nums, 0, nums.length - 1);
        }

        private int quickSelect(int[] nums, int left, int right) {
            int index = partition(nums, left, right);
            if (index > k) {
                return quickSelect(nums, left, index - 1);
            } else if (index < k) {
                return quickSelect(nums, index + 1, right);
            } else {
                return nums[index];
            }
        }

        private int partition(int[] nums, int left, int right) {
            if (left >= right) {
                return left;
            }
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < nums[left]) {
                    j++;
                    swap(nums, j, i);
                }
            }
            swap(nums, left, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
