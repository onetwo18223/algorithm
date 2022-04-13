package com.bhh.leetcode.swordfingeroffertwobrushes.array.sort;

/**
 * @author bhh
 * @description 调整数组顺序使奇数位于偶数前面
 * @date Created in 2022-01-12 18:55
 * @modified By
 */
public class Question21 {
    class Solution {
        /*
        使用快排思想完成奇数在前偶数在后
         */
        public int[] exchange(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int left = 0, right = nums.length - 1;
            // 结束条件为 left = right + 1
            while (left <= right) {
                while (left <= right && nums[left] % 2 == 1) {
                    left++;
                }
                while (left <= right && nums[right] % 2 == 0) {
                    right--;
                }
                if (left <= right) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
            }
            return nums;
        }
    }
}
