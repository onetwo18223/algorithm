package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 排序链表
 * @date Created in 2022-01-23 22:06
 * @modified By
 */
public class Question148 {
    class Solution {
        /*
        递归解决
        使用归并排序, 从单元素到多元素
         */
        public ListNode sortList(ListNode head) {
            return sort(head, null);

        }

        /**
         * 归并排序
         * @param start 开始点
         * @param end 结束点
         * @return
         */
        private ListNode sort(ListNode start, ListNode end) {
            if (start == end) {
                return start;
            }
            // 寻找中心点
            ListNode slow = start;
            ListNode fast = start;
            // 结束 链表为奇数时指向中间位, 偶数时指向中间线靠右位置
            while (fast != end && fast.next != end) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode son2 = sort(slow.next, end);
            // 这里为什么要分成俩段, 为了保证子链表一定是递增的
            // 如果不分, 则对于前半段而言, 是增 + 乱的情况
            slow.next = null;
            ListNode son1 = sort(start, slow);
            return merge(son1, son2);
        }

        private ListNode merge(ListNode son1, ListNode son2) {
            if (son1 == null || son2 == null) {
                return son1 == null ? son2 : son1;
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
