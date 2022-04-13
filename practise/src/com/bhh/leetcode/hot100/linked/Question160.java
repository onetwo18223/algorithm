package com.bhh.leetcode.hot100.linked;

/**
 * @author bhh
 * @description 相交链表
 * @date Created in 2021-12-23 15:23
 * @modified By
 */
public class Question160 {
    public class Solution {
        /*
        Hash可以解决问题
        但是题目要求不适用额外的空间
        那么就使用 环形链表的快慢双指针 完成
        将尾部和headB的头部相连, 形成环, 然后循环, 获取环入口点, 最后需要将环解开
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null){
                return null;
            }
            ListNode slow = headA;
            while (slow.next != null){
                slow = slow.next;
            }
            // 获取结尾的点
            ListNode end = slow;
            // 首尾相连
            end.next = headB;
            ListNode fast = headA.next;

            slow = headA;
            // 结束条件 slow == fast
            while (slow != fast){
                if (fast == null || fast.next == null){
                    end.next = null;
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode start = headA;
            // 结束条件 start == slow.next
            while (start != slow.next){
                start = start.next;
                slow = slow.next;
            }

            // 解环
            end.next = null;
            return start;
        }
    }
}
