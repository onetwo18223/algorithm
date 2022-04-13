package com.bhh.leetcode.hot100twobrushes.array.hash;

/**
 * @author bhh
 * @description 寻找重复数
 * @date Created in 2022-01-11 21:17
 * @modified By
 */
public class Question287 {
    class Solution {
        /*
        Hash/环形链表/二分查找(索引)
        环形链表
         */
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            while (true) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                if (slow == fast) {
                    break;
                }
            }
            slow = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
