package org.qa.twopointer.copointer.speed;

/**
 * @Desc 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * 实现：
 * 类似于Question141环形链表I，先寻找环形链表入口点
 * 然后将head和入口点.next同时步进，相遇点就是所求点
 * @Author bhh
 * @Date 2023-03-01 10:57
 * @Version 1.0
 */
public class Question142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (null == head) return null;
            ListNode left = head;
            ListNode right = head.next;
            while (left != right) {
                if (right == null || right.next == null) return null;
                left = left.next;
                right = right.next.next;
            }
            // TODO: 将一个节点指向head，另一个节点指向换入口点.next
            left = head;
            right = right.next;
            while (left != right) {
                left = left.next;
                right = right.next;
            }
            return left;
        }
    }
}
