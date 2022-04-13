package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 反转链表 II
 * @date Created in 2022-02-05 10:08
 * @modified By
 */
public class Question92 {
    class Solution {
        /*
        反转指定位置的链表
        链表的各个节点值应当是不同的
        遍历链表, 寻找起始点, 开始反转, 然后寻找结尾点
        反转是翻转指向, 开始点变为 pre, 结束点变为开始点
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode preHead = new ListNode();
            preHead.next = head;
            ListNode p = preHead;
            // 结束 p == null || p.next == left
            int index = 1;
            while (p != null) {
                if (index == left) {
                    break;
                }
                p = p.next;
                index++;
            }
            ListNode start = p;
            ListNode reserveStart = p.next;
            p = reserveStart;
            ListNode pre = null;
            ListNode next = null;
            // 结束时, pre为翻转后的链表头, 链表尾变为reserveStart
            while (p != null) {
                next = p.next;
                p.next = pre;
                pre = p;
                p = next;
                if (index++ == right) {
                    break;
                }
            }
            // 进行拼接
            start.next = pre;
            reserveStart.next = p;
            return preHead.next;
        }
    }
}
