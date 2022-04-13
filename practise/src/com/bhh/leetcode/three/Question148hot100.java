package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 排序链表
 * @date Created in 2022-01-30 11:22
 * @modified By
 */
public class Question148hot100 {
    class Solution {
        /*
        方法一 : 转数组
        方法二 : 适合链表的排序 : 归并排序
            找中点, 分开, 再合并
         */
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            return sort(head, null);
        }

        private ListNode sort(ListNode head, ListNode tail) {
            if (head == tail) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            // 结束 p 指向中点(奇数), 靠右的数(偶数)
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode son2 = sort(slow.next, tail);
            slow.next = null;
            ListNode son1 = sort(head, slow);
            return merge(son1, son2);
        }

        private ListNode merge(ListNode son1, ListNode son2) {
            if (son1 == null) {
                return son2;
            }
            if (son2 == null) {
                return son1;
            }
            if (son1.val > son2.val) {
                son2.next = merge(son1, son2.next);
                return son2;
            } else {
                son1.next = merge(son1.next, son2);
                return son1;
            }
        }
    }
}
