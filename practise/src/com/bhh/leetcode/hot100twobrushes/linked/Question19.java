package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 删除链表的倒数第 N 个结点
 * @date Created in 2022-01-23 11:50
 * @modified By
 */
public class Question19 {
    class Solution {
        /*
        使用快慢双指针删除
        删除节点是一定需要一个虚拟头节点的
        而且删除节点同样需要被删除点的前一个元素
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode preHead = new ListNode();
            preHead.next = head;
            ListNode slow = preHead;
            ListNode fast = preHead;
            while (n != 0) {
                fast = fast.next;
                n--;
            }
            // 获取要删除节点的前一个元素
            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return preHead.next;
        }
    }
}
