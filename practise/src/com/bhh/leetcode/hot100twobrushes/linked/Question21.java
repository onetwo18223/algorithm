package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 合并两个有序链表
 * @date Created in 2022-01-23 9:41
 * @modified By
 */
public class Question21 {
    class Solution {
        /*
        递归
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode node = new ListNode();
            if (list1.val > list2.val) {
                node.val = list2.val;
                node.next = mergeTwoLists(list1, list2.next);
            } else {
                node.val = list1.val;
                node.next = mergeTwoLists(list1.next, list2);
            }
            return node;
        }
    }
}
