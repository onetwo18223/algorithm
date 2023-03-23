package org.problem.linkedlist;

/**
 * 归并排序
 * 获取中间节点
 * 分成俩段，进行合并
 */
public class Question148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        public ListNode mergeSort(ListNode head) {
            // 当head.next == null时 说明当前链表只有一个元素 无序再排序
            if (head == null || head.next == null) {
                return head;
            }
            // 找到中间节点
            ListNode mid = findMid(head);
            // 存储中间节点的下一个结点
            ListNode next = mid.next;
            // 从中间结点断开 分别对两边进行mergeSort
            mid.next = null;
            // 返回排序后的头节点
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(next);

            // 返回合并之后的头节点
            return merge(left, right);
        }

        // 获取中间点
        public ListNode findMid(ListNode head) {
            if (head == null) return head;

            ListNode fast = head.next;  // 快指针 每次走2步
            ListNode slow = head;       // 慢指针 每次走1步
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode curr = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }

            if (l1 != null) {
                curr.next = l1;
            }

            if (l2 != null) {
                curr.next = l2;
            }
            return dummy.next;
        }
    }
}
