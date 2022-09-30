package org.problem.linkedlist;

/**
 * 反转链表
 *
 * 实现：原地反转
 * 需要俩个指针，一个为next指向下一个应该遍历的元素，另一个为pre指向前一个元素
 * 遍历链表，都使用next承接下一个元素，后将node.next转向pre(完成指针转向)，
 * 且对pre重新赋值，最后将next重新赋值给node
 */
public class Question206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return head;
            ListNode pre = null, next = null;
            ListNode node = head;
            while(node != null) {
                next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            return pre;
        }
    }
}
