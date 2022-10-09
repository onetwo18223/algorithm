package org.problem.linkedlist;

/**
 * 合并两个有序链表
 *
 * 类似于Question2两数相加
 */
public class Question21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val > list2.val) {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
}
