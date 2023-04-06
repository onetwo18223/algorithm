package org.qa.linkedlist;

/**
 * @Desc 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @Author Bhh
 * @Date 2023-04-03 17:20
 * @Version 1.0
 */
public class Question19 {
    {
        /* 实现：
        快慢双指针
         */
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (null == head) return head;
            // 创建虚拟头
            ListNode pre = new ListNode(0, head);
            // 使用快慢双指针寻找要删除节点的前一个节点
            ListNode slow = pre;
            ListNode fast = pre.next; // head
            for (int i = 0; i < n; i++) fast = fast.next;
            // 循环结束slow指向要删除节点的前一个节点
            while(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            // 删除节点
            slow.next = slow.next.next;
            return pre.next;
        }
    }
}
