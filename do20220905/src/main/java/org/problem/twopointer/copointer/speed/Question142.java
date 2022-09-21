package org.problem.twopointer.copointer.speed;

/**
 * 环形链表 II
 *
 * 实现：使用双指针，指针1每次走俩步，指针2每次走一步
 *      若是双指针最终相遇则证明是环形链表
 *      此时，从head和相遇点开始，每次循环走一步，俩指针相遇点位环形链表入口
 */
public class Question142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // 若链表无环则返回null
            if (head == null) return null;
            ListNode node1 = head;
            ListNode node2 = head.next;
            while(node1 != node2) {
                if (node2 == null || node2.next == null) return null;
                node1 = node1.next;
                node2 = node2.next.next;
            }
            // 将头结点赋值给node2，开始循环获取环形链表起始点
            node2 = head;
            // node1先向前走一次
            node1 = node1.next;
            while(node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }
    }
}
