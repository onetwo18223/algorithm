package org.qa.linkedlist;

/**
 * @Desc 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 * 实现：
 * 原地翻转实现
 * @Author Bhh
 * @Date 2023-04-03 17:03
 * @Version 1.0
 */
public class Question206 {
    class Solution {
        ListNode pre = null;
        public ListNode reverseList(ListNode head) {
            reverse(head);
            return pre;
        }

        private ListNode reverse(ListNode head) {
            if (null == head) return head;
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            reverseList(next);
            return head;
        }
    }
}
