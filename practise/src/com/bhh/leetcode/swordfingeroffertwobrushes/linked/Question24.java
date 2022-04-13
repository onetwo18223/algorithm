package com.bhh.leetcode.swordfingeroffertwobrushes.linked;

/**
 * @author bhh
 * @description 反转链表
 * @date Created in 2022-01-15 12:44
 * @modified By
 */
public class Question24 {
    class Solution {
        /*
        更改每个节点的指向
         */
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pre = null, next = null;
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
