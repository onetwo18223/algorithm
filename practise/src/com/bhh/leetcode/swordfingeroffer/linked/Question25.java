package com.bhh.leetcode.swordfingeroffer.linked;

import com.bhh.leetcode.swordfingeroffer.stackandqueue.Question59_1;

/**
 * @author bhh
 * @description 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date Created in 2021-09-24 14:14
 * @modified By
 */
public class Question25 {
    class Solution {
        /*
        实现思路 : 归并思路
        俩个指针, 一个指针指向l1链表要进行比较的节点, 另一个指向l2
        需要新的链表
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            // 新链表头结点
            ListNode head = new ListNode(0);
            ListNode p = head;
            ListNode l = l1;
            ListNode r = l2;

            //
            while (l != null || r != null) {
                // 左侧节点加载完了, 加载右侧
                if (l == null) {
                    p.next = r;
                    r = r.next;
                } else if (r == null) {
                    p.next = l;
                    l = l.next;
                }
                // 俩个链表都有节点剩余, 则进行值比较
                else if (l.val >= r.val) {
                    p.next = r;
                    r = r.next;
                } else if (l.val < r.val) {
                    p.next = l;
                    l = l.next;
                }
                p = p.next;
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        LinkedUtil.OutListNode(new Question25().new Solution().mergeTwoLists(LinkedUtil.getInstance(new int[]{
                1, 2, 4
        }), LinkedUtil.getInstance(new int[]{1, 3, 4})));

    }
}
