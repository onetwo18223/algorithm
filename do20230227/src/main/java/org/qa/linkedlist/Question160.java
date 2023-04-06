package org.qa.linkedlist;

/**
 * @Desc 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 实现：
 *
 * @Author Bhh
 * @Date 2023-04-03 15:25
 * @Version 1.0
 */
public class Question160 {
    {
        /* 实现：
         + 使用环形链表方式完成
              连接A的head和end
              判断是否是环形链表
              判断环形链表的入口 Question141
         + 从俩个head开始，遍历俩次，当俩个节点相等时为相交节点
         */
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (null == headA || null == headB) return null;
            ListNode left = headA;
            ListNode right = headB;
            // TODO: 需要进行判断是否是第1次循环结束
            //  此处并不需要判断俩个链表是否都是第一次循环
            //  只需要判断第一个链表是否第一次，
            //  而第二个链表即使在一直循环，也可以判断第一个链表是否为null来结束循环
            int ringNum = 0;
            while(left != right && left != null) {
                left = left.next;
                if (null == left && ringNum == 0) {
                    ringNum++;
                    left = headB;
                }
                right = right.next;
                if (null == right) right = headA;
            }
            return left == right ? left : null;
        }
    }
}
