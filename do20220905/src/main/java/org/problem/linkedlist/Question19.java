package org.problem.linkedlist;

/**
 * 删除链表的倒数第N个结点
 * 栈结构 / 翻转 * 2
 * 没想到：快慢双指针方法
 */
public class Question19 {
    /**
     * 翻转 * 2
     */
    class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            head = reserve(head);
            // 创建虚拟头结点
            ListNode preHead = new ListNode();
            preHead.next = head;
            // 寻找指定结点前一个节点和后一个节点
            ListNode node = preHead, pre = preHead;
            int count = 0;
            while (node != null) {
                if (count++ + 1 == n) {
                    pre = node;
                }
                node = node.next;
            }
            pre.next = pre.next.next;
            // 删除preHead
            head = preHead.next;
            preHead.next = null;
            return reserve(head);
        }

        private ListNode reserve(ListNode head) {
            ListNode pre = null, next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    /**
     * 双指针算法
     *
     * 做法类似于OfferQuestion 22. 链表中倒数第k个节点
     */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode preHead = new ListNode(0, head);
            // 为什么快指针指向head而不是preHead
            // 因为是删除结点
            ListNode fast = head;
            ListNode slow = preHead;
            // 让fast向前运行n个结点
            for (int i = 0; i < n; i++) fast = fast.next;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return preHead.next;
        }
    }
}
