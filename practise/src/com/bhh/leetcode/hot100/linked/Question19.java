package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 删除链表的倒数第 N 个结点
 * @date Created in 2021-12-24 9:14
 * @modified By
 */
public class Question19 {
    class Solution {
        /*
        遍历一次, 有倒数第n个节点转为正数第x的节点
        因为头结点都有可能被删除, 所以创建虚拟头结点
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // if (head == null || head.next == null){
            //     return null;
            // }
            ListNode p = head;
            int size = 1;
            while (p.next != null) {
                p = p.next;
                size++;
            }
            n = size - n;
            // 创建
            ListNode pre = new ListNode();
            pre.next = head;
            p = pre;
            int i = 0;
            while (p != null){
                if (i == n && p.next != null){
                    p.next = p.next.next;
                }
                p = p.next;
                i++;
            }
            return pre.next;
        }

        /*
        Plus版本, 只需一次遍历
        同向双指针/快慢双指针, 双指针之间的距离稳定为n,
        当fast.next == null时, 代表slow指针的next节点需要被删除
         */
        public ListNode removeNthFromEndPlus(ListNode head, int n) {
            ListNode pre = new ListNode();
            pre.next = head;
            ListNode slow = pre;
            ListNode fast = pre;
            while (n != 0) {
                fast = fast.next;
                n--;
            }
            // 结束 : fast是链表最后一个节点, slow.next节点是需要删除的节点
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return pre.next;
        }
    }
}
