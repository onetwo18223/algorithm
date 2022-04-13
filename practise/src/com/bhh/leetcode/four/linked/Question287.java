package com.bhh.leetcode.four.linked;

/**
 * @author bhh
 * @description 寻找重复数
 * @date Created in 2022-03-04 16:30
 * @modified By
 */
public class Question287 {
    class Solution {
        /*
        环形链表问题
         */
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            while (true) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                if (slow == fast) {
                    break;
                }
            }
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
