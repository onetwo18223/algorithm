package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 反转链表
 * @date Created in 2022-01-23 9:49
 * @modified By
 */
public class Question206 {
    class Solution {
        /*
        原地翻转 : 转换指向
         */
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pre = null;
            ListNode next = null;
            ListNode p = head;
            while (p != null) {
                next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }
    }
}
