package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 相交链表
 * @date Created in 2022-01-23 13:06
 * @modified By
 */
public class Question160 {
    public class Solution {
        /*
        Hash, 形成环, 俩次遍历
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;
            while (p != q) {
                p = p.next;
                q = q.next;
                if (p == null && q == null){
                    return null;
                }
                if (p == null) {
                    p = headB;
                }
                if (q == null) {
                    q = headA;
                }
            }
            return p;
        }
    }
}
