package com.bhh.leetcode.hot100twobrushes.array.other;

/**
 * @author bhh
 * @description 寻找重复数
 * @date Created in 2022-01-22 11:33
 * @modified By
 */
public class Question287 {
    class Solution {
        /**
         * 可以使用Hash, 原地交换, 二分法, 循环
         * 题意要求使用二分或者循环
         * @param nums
         * @return
         */
        // 循环
        public int findDuplicate(int[] nums) {
            // 快慢双指针
            int slow = 0, fast = 0;
            // 结束 slow == fast
            while (true) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                if (slow == fast) {
                    break;
                }
            }
            slow = 0;
            // 结束slow == fast
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
