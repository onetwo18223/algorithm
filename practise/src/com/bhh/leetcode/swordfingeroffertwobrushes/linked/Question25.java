package com.bhh.leetcode.swordfingeroffertwobrushes.linked;

/**
 * @author bhh
 * @description 合并两个排序的链表
 * @date Created in 2022-01-15 13:13
 * @modified By
 */
public class Question25 {
    class Solution {
        /*
        合并俩个排序的链表
        方法一 : 递归
        方法二 : 归并
        这俩种方法都免不了额外空间
        这道题再次提出问题, 链表不同于数组, 数组归并需要一个一个比对, 合并就有四种情况,
        但是链表在某一个链表的情况下可以直接继承而不用递归
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode left = l1;
            ListNode right = l2;
            ListNode head = new ListNode(0);
            ListNode p = head;
            while (left != null && right != null) {
                if (left.val > right.val) {
                    p.next = right;
                    right = right.next;
                } else if (left.val <= right.val) {
                    p.next = left;
                    left = left.next;
                }
                p = p.next;
            }
            p.next = left == null ? right : left;
            return head.next;
        }
    }
}
