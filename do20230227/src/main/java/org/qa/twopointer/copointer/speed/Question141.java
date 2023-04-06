package org.qa.twopointer.copointer.speed;

/**
 * @Desc 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 * @Author bhh
 * @Date 2023-02-28 17:21
 * @Version 1.0
 */
public class Question141 {
    {
        /* 实现：
        快慢双指针问题，
        快指针一次走俩步，慢指针一次走一步
         */
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (null == head) return false;
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (null == fast || null == fast.next) return false;
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
