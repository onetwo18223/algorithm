package com.bhh.leetcode.four.linked;

/**
 * @author bhh
 * @description 环形链表 II
 * @date Created in 2022-03-04 15:46
 * @modified By
 */
public class Question142 {
    public class Solution {
        /*
        环形链表问题
         */
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (true) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == null || fast.next == null) {
                    return null;
                }
                if (slow == fast) {
                    break;
                }
            }
            while (slow != head) {
                head = head.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
