package com.bhh.leetcode.swordfingeroffer.array;

import java.util.Arrays;

/**
 * @author bhh
 * @description 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * @date Created in 2021-09-15 14:18
 * @modified By
 */
public class Question21 {
    class Solution {
        /*
        实现思路 :
        单路快排实现
        双指针: 一个指针指向当前遍历位, 一个指针指向奇数位最后一位
        遍历数组, 碰到奇数则不变, 碰到偶数则和偶数位
         */
        public int[] exchange(int[] nums) {
            // j变量指向的是奇数位的最后一位
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                // 奇数
                if (nums[i] % 2 != 0) {
                    swap(nums, i, j++);
                }
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution test = new Question21().new Solution();
        Arrays.stream(test.exchange(new int[]{1, 2, 3, 4, 6, 5})).forEach(System.out::println);
    }
}
