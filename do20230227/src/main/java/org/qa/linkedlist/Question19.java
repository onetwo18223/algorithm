package org.qa.linkedlist;

/**
 * @Desc 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 实现：
 * 快慢双指针
 * @Author Bhh
 * @Date 2023-04-03 17:20
 * @Version 1.0
 */
public class Question19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (null == head) return head;
            // 创建虚拟头
            ListNode pre = new ListNode();
            pre.next = head;

            ListNode slow = pre;
            ListNode fast = pre;
            while(n > 0) {
                fast = fast.next;
                n--;
            }
            while(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

        }
    }
}
