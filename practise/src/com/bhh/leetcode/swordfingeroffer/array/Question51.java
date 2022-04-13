package com.bhh.leetcode.swordfingeroffer.array;

/**
 * @author bhh
 * @description
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * @date Created in 2021-09-14 10:41
 * @modified By
 */
public class Question51 {
    class Solution {
        /**
         * 暴力解法
         * @param nums
         * @return
         */
        public int reversePairs(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]){
                        sum++;
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution test = new Question51().new Solution();
        System.out.println(test.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
