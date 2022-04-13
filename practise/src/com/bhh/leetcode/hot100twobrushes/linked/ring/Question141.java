package com.bhh.leetcode.hot100twobrushes.linked.ring;

import com.bhh.leetcode.hot100twobrushes.linked.ListNode;

/**
 * @author bhh
 * @description 环形链表
 * @date Created in 2022-01-11 21:30
 * @modified By
 */
public class Question141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
        }
    }
}
