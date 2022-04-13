package com.bhh.leetcode.four.linked;

/**
 * @author bhh
 * @description 两数相加
 * @date Created in 2022-03-05 12:05
 * @modified By
 */
public class Question2 {
    class Solution {
        /*
        直接使用递归相加
         */
        int pre = 0;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                if (pre != 0) {
                    return new ListNode(pre);
                }
                return null;
            }
            int value = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val) + pre;
            pre = value / 10;
            value = value % 10;
            ListNode node = new ListNode(value);
            node.next = addTwoNumbers(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next);
            return node;
        }
    }
}
