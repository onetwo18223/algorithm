package org.problem.linkedlist;

/**
 * 相交链表
 *
 * 实现：使用遍历，从node1从headA遍历到结尾，同时node2从headB也遍历，到结尾之后，
 * node1再从headB开始遍历，node2从headA开始遍历
 * 相遇为相交节点
 *
 * 或者连接收尾成环，使用环形链表2解决方法
 */
public class Question160 {
    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode node1 = headA;
            ListNode node2 = headB;
            int count = 0;
            while(node1 != node2 && (node1 != null && node2 != null)) {
                node1 = node1.next;
                node2 = node2.next;
                if (node1 == null && count == 0) {
                    node1 = headB;
                    count++;
                }
                if (node2 == null) node2 = headA;
            }
            if (node1 == node2) return node1;
            return null;
        }
    }

    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            // 获取结尾节点
            ListNode tail = headA;
            while(tail.next != null) {
                tail = tail.next;
            }
            // 成环
            tail.next = headB;

            ListNode slow = headA;
            ListNode fast = headA.next;
            while(slow != fast) {
                if (fast == null || fast.next == null) {
                    tail.next = null;
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = headA;
            slow = slow.next;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            // 解环
            tail.next = null;
            return slow;
        }
    }
}
