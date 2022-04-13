package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 合并两个有序链表
 * @date Created in 2021-12-24 19:10
 * @modified By
 */
public class Question21 {
    class Solution {
        /*
        合并俩个有序链表, 归并排序的雏形
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null){
                return list2;
            }
            if (list2 == null){
                return list1;
            }
            ListNode res = new ListNode();
            ListNode p = res;
            while (list1 != null || list2 != null) {
                if (list1 == null) {
                    p.next = list2;
                    list2 = list2.next;
                    p = p.next;
                } else if (list2 == null) {
                    p.next = list1;
                    list1 = list1.next;
                    p = p.next;
                } else if (list1.val > list2.val){
                    p.next = list2;
                    list2 = list2.next;
                    p = p.next;
                } else {
                    p.next = list1;
                    list1 = list1.next;
                    p = p.next;
                }
            }
            return res.next;
        }
    }
}
