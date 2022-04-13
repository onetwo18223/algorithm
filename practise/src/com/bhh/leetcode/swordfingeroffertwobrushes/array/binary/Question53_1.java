package com.bhh.leetcode.swordfingeroffertwobrushes.array.binary;

/**
 * @author bhh
 * @description 在排序数组中查找数字 I
 * @date Created in 2022-01-12 10:24
 * @modified By
 */
public class Question53_1 {
    class Solution {
        /*
        第一眼看的时候想到的是Hash, 忽略了有序数组
        数组 + 有序 + target = 二分
        获取最左边的target位置
         */
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int start = 0, end = nums.length - 1;
            // 结束 start + 1 = end
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            start = nums[start] == target ? start : end;
            int num = 1;
            while (start < nums.length && nums[start] == target) {
                start++;
                num++;
            }
            return num;
        }
    }
}
