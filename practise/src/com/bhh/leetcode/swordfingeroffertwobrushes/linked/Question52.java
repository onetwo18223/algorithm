package com.bhh.leetcode.swordfingeroffertwobrushes.linked;

/**
 * @author bhh
 * @description 两个链表的第一个公共节点
 * @date Created in 2022-01-15 13:35
 * @modified By
 */
public class Question52 {
    public class Solution {
        /*
        我的想法, 将链表B头和链表尾进行相连形成循环链表, 使用快慢指针,
        慢指针一次一格, 快指针一次俩格, 相遇说明有相遇点
        这时慢指针从头开始走, 快指针从相遇点开始走, 再次相遇点就是公共点

        更优解 : 俩个链表向前走, 碰到链表尾则继续走对方链表, 直到相遇为止
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode p = headA, q = headB;
            while (p != q) {
                p = p == null ? headB : p.next;
                q = q == null ? headA : q.next;
            }
            return q;
        }

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        node.next = new ListNode(3);
         System.out.println(new Question52().
                new Solution().getIntersectionNode(node,
                new ListNode(2)));
    }
}
