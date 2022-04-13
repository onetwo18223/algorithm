package com.bhh.leetcode.four;

/**
 * @author bhh
 * @description 两数相加
 * @date Created in 2022-02-22 20:26
 * @modified By
 */
public class Question2 {
    class Solution {
        /*
        链表类题目,
            应该想到递归遍历/循环遍历, 对于单个节点处理, 使用递归更佳
         */
        int pre = 0;
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return add(l1, l2);
        }

        ListNode preHead = new ListNode();
        /*
        按照从后往前的顺序进行添加
        1.更换为数组
        2.链表翻转, 然后添加
         */
        public ListNode addTwoNumbersReserve(ListNode l1, ListNode l2) {
            // 先翻转链表
            l1 = reserve(l1);
            System.out.println(l1.val);
            l2 = reserve(l2);
            System.out.println(l2.val);
            return add(l1, l2);
        }

        private ListNode reserve(ListNode node) {
            ListNode pre = null;
            ListNode next = null;
            while (node != null) {
                next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            return pre;
        }

        private ListNode add(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                if (pre == 1) {
                    return new ListNode(1);
                }
                return null;
            }
            int value = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val) + pre;
            pre = value >= 10 ? 1 : 0;
            value %= 10;
            ListNode node = new ListNode(value);
            node.next = addTwoNumbers(l1 != null ? l1.next : null,
                    l2 != null ? l2.next : null);
            return node;
        }

    }
}
