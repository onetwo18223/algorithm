package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 两数相加
 * @date Created in 2022-01-23 8:53
 * @modified By
 */
public class Question2 {
    class Solution {
        /*
        递归/循环
         */
        int pre = 0;

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return add(l1, l2);
        }

        private ListNode add(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                if (pre == 1) {
                    return new ListNode(1);
                }
                return null;
            }
            int value = (l1 != null ? l1.val : 0) +
                    (l2 != null ? l2.val : 0) + pre;
            pre = value >= 10 ? 1 : 0;
            value %= 10;
            ListNode node = new ListNode(value);
            node.next = add((l1 != null ? l1.next : null),
                    (l2 != null ? l2.next : null));
            return node;
        }
    }
}
