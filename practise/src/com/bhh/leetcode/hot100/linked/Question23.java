package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 合并K个升序链表
 * @date Created in 2022-01-05 20:13
 * @modified By
 */
public class Question23 {
    class Solution {
        /*
        在之前有一道题目是 合并俩个升序链表
        使用归并可以快速完成
        这道题目是K个升序链表合并
        使用归并合并, 中间多加一层而已

        这道题核心就是将多个链表转换成俩个链表的形式
        这里使用到的思想就是归并排序, 是由单位排序到更大的排序
        实现就是一直后续遍历, 直到单个元素为止, 再合并俩个这样的单元素
         */
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        // 进行合并
        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            // 后续遍历, 会先分成最小单位, 也就是一个leftNode和一个rightNode
            ListNode leftNode = merge(lists, left, mid);
            ListNode rightNode = merge(lists, mid + 1, right);
            // 合并俩个链表
            return mergeTwoList(leftNode, rightNode);
        }

        private ListNode mergeTwoList(ListNode node1, ListNode node2) {
            ListNode head = new ListNode();
            ListNode p = head, left = node1, right = node2;
            // 结束条件是 left == null || right == null
            while (left != null && right != null) {
                if (left.val > right.val) {
                    p.next = right;
                    right = right.next;
                } else {
                    p.next = left;
                    left = left.next;
                }
                p = p.next;
            }
            // 极端情况就是俩个都是null, 但是无所谓
            p.next = left != null ? left : right;
            return head.next;
        }
    }
}
