package org.problem.twopointer.copointer.speed;

/**
 * 环形链表
 * <p>
 * 实现：双指针，指针1每次走俩步，指针2每次走一步，
 *      如果双指针可以相遇则证明是环形
 */
public class Question141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode node1 = head;
            ListNode node2 = head.next;
            while (node1 != node2) {
                if (node2 == null || node2.next == null) {
                    return false;
                }
                node1 = node1.next;
                node2 = node2.next.next;
            }
            return true;
        }
    }
}
