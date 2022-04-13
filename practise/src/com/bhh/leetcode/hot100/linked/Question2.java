package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 给你两个非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * @date Created in 2021-11-04 19:43
 * @modified By
 */
public class Question2 {
    class Solution {
        /*
        实现思路 : 在学习位运算时, 异或表示不进位的加法, & >> 1表示进位情况

        先不考虑进位的情况完成初始值再考虑进位问题
        或者
        一步到位, 遍历长度较长的链表, 使用属性来完成进位存储,
            若是循环完成后, 判断进位属性仍然需要进位则加一位
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode head = new ListNode();
            ListNode p3 = head;
            int c = 0;
            while (p1 != null || p2 != null) {
                // 若是p1 == null || p2 == null, 则为null的节点数值为0
                int sum = (p1 == null ? 0 : p1.val) +
                        (p2 == null ? 0 : p2.val);
                // 判断sum是否需要进位
                sum += c;
                if (sum >= 10) {
                    sum -= 10;
                    c = 1;
                } else {
                    c = 0;
                }
                // 创建链表
                p3.next = new ListNode(sum);
                p3 = p3.next;
                p1 = p1 != null ? p1.next : p1;
                p2 = p2 != null ? p2.next : p2;
            }
            // 仍然需要进位
            if (c == 1) {
                p3.next = new ListNode(1);
            }
            return head.next;
        }
    }
}
