package com.bhh.leetcode.swordfingeroffertwobrushes.linked;

/**
 * @author bhh
 * @description 删除链表的节点
 * @date Created in 2022-01-15 15:48
 * @modified By
 */
public class Question18 {
    class Solution {
        /*
        删除某一个节点, 链表删除节点需要知道前一个元素
         */
        public ListNode deleteNode(ListNode head, int val) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode p = dummyHead;
            // 结束 p.next == null
            while (p != null && p.next != null) {
                if (p.next.val == val) {
                    p.next = p.next.next;
                }
                p = p.next;
            }
            return dummyHead.next;
        }
    }
}
