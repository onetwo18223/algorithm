package com.bhh.leetcode.hot100twobrushes.array.sort;

/**
 * @author bhh
 * @description 移动零
 * @date Created in 2022-01-21 14:34
 * @modified By
 */
public class Question283 {
    class Solution {
        /*
        错误 :
        移动0, 且保持相对顺序, 快排,
        原因 : 若是直接使用快排则不稳定!
         */
        public void moveZeroesError(int[] nums) {
            int left = 0, right = nums.length - 1;
            // 结束 left == right
            while (left < right) {
                while (left < right && nums[left] != 0) {
                    left++;
                }
                while (left < right && nums[right] == 0) {
                    right--;
                }
                // 交换
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        /*
        若要使用快排思想, 则需要使用同向双指针
        双路快排
         */
        public void moveZeroesT(int[] nums) {
            int left = 0, right = 0;
            // 结束 len == right
            while (right < nums.length) {
                while (left < right && nums[left] != 0) {
                    left++;
                }
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                if (right < nums.length) {
                    // 交换
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                    right++;
                }
            }
        }
        /*
        若要使用快排思想, 则需要使用同向双指针
        单路快排
         */
        public void moveZeroes(int[] nums) {
            int left = 0, right = 0;
            // 结束 len == right
            while (right < nums.length) {
                if (nums[right] != 0) {
                    int tmp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = tmp;
                    left++;
                }
                right++;
            }
        }
    }
}
