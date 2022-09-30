package org.problem.linkedlist;

/**
 * 两数相加
 */
public class Question2 {
    class Solution {
        int pre = 0;
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null && pre == 0) return null;
            int sum = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 :l2.val) + pre;

            if (sum >= 10) {
                sum %= 10;
                pre = 1;
            } else pre = 0;
            ListNode temp = new ListNode(sum);
            temp.next = addTwoNumbers(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next);
            return temp;
        }
    }
}
