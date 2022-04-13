package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 删除链表的倒数第 N 个结点
 * @date Created in 2022-02-01 13:04
 * @modified By
 */
public class Question19hot100 {
    class Solution {
        /*
        删除链表某个节点, 找到该节点的前一个节点
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode preHead = new ListNode();
            preHead.next = head;
            ListNode slow = preHead;
            ListNode fast = preHead;
            while (fast != null && n != 0) {
                fast = fast.next;
                n--;
            }
            // 结束 slow指向要删除节点的前一个节点
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return preHead.next;
        }
    }
}
