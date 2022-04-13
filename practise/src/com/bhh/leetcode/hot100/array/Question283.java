package com.bhh.leetcode.hot100.array;

/**
 * @author bhh
 * @description 移动零
 * @date Created in 2021-12-22 9:58
 * @modified By
 */
public class Question283 {
    class Solution {
        /*
        错误解法
        快排思想, 直接快排会造成顺序出错
         */
        public void moveZeroesError(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int start = 0, end = nums.length - 1;
            while (start <= end) {
                while (start <= end && nums[start] != 0) {
                    start++;
                }
                while (start <= end && nums[end] == 0) {
                    end--;
                }
                if (start <= end) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
            }
        }

        /*
        同向双指针
         */
        public void moveZeroes1(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int start = 0, end = 0;
            while (end <= nums.length - 1) {
                while (end <= nums.length - 1 && nums[end] != 0) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end++;
                }
                end++;
            }
        }
        /*
        这道题虽然考察双指针, 但是遍历, 发现0覆盖, 然后后面补0, 可能更好一点
         */
        public void moveZeroes(int[] nums) {
        }
    }
}
