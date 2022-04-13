package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 反转链表
 * @date Created in 2021-12-24 15:23
 * @modified By
 */
public class Question206 {
    class Solution {
        /*
        反转链表
        方法一 : 使用栈, 重新排列节点
        方法二 : 反转next的指向
         */
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next;
            while (head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}
