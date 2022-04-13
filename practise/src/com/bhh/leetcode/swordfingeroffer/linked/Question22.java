package com.bhh.leetcode.swordfingeroffer.linked;

/**
 * @author bhh
 * @description 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * @date Created in 2021-09-24 11:31
 * @modified By
 */
public class Question22 {
    class Solution {
        /*
        实现思路 : 先对链表进行一次遍历, 获取节点总数sum,
        再次遍历节点, 当在第 sum - k 个节点时返回
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int sum = 0;
            ListNode p = head;
            // 第一次遍历获取节点总数
            while (p != null) {
                sum++;
                p = p.next;
            }
            p = head;
            for (int i = 0; i < sum; i++) {
                if (i == (sum - k)) {
                    return p;
                }
                p = p.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        LinkedUtil.OutListNode(
                new Question22().new Solution().getKthFromEnd(
                        LinkedUtil.getInstance(new int[]{1, 2, 3, 4, 5}), 4));
    }
}
