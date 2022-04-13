package com.bhh.leetcode.swordfingeroffertwobrushes.array.binary;

/**
 * @author bhh
 * @description 0～n-1中缺失的数字
 * @date Created in 2022-01-12 12:13
 * @modified By
 */
public class Question53_2 {
    class Solution {
        /*
        二分(索引和数值比较)/ 遍历, 获取索引和数值不对应的位置( 原地交换的思路 )
         */
        public int missingNumber(int[] nums) {
            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] > mid) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[start] == start && nums[end] == end) {
                return nums.length;
            }
            return nums[start] == start ? end : nums[start] - 1;
        }
    }
}
