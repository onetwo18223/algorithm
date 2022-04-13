package com.bhh.leetcode.swordfingeroffertwobrushes.linked;

/**
 * @author bhh
 * @description 链表中倒数第k个节点
 * @date Created in 2022-01-15 12:29
 * @modified By
 */
public class Question22 {
    class Solution {
        /*
        关于链表的问题转换为数组, 很多都可以以数组的形式来解决
        但是这样会增加时间复杂度
        所以更优解是 直接在链表上做文章
        例如这道题, 我们直接转换为数组, 从后往前获取倒数第k个元素即可
            但是更优解获取是定义双指针, 将俩个指针的间距设置为k,
                当fast指针的下一个元素为null时, slow指针指向的节点就是结果
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            // 结束 fast == null
            while (fast != null) {
                // 结束时 fast和slow相差k个单位
                // 结束 fast == null || k == 0
                while (fast != null && k != 0) {
                    fast = fast.next;
                    k--;
                }
                if (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            return slow;
        }
    }
}
