package com.bhh.leetcode.swordfingeroffertwobrushes.array.twopoint;

/**
 * @author bhh
 * @description 和为s的两个数字
 * @date Created in 2022-01-12 22:28
 * @modified By
 */
public class Question57 {
    class Solution {
        /*
        因为是有序的, 可以使用相向双指针获取组合
         */
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    break;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            res[0] = nums[left];
            res[1] = nums[right];
            return res;
        }
    }
}
