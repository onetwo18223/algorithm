package com.bhh.leetcode.four.linked;

/**
 * @author bhh
 * @description 回文链表
 * @date Created in 2022-03-04 14:59
 * @modified By
 */
public class Question234 {
    class Solution {
        /*
        寻找中心点去判断是否是回文链表
         */
        public boolean isPalindrome(ListNode head) {
            // 寻找中心点
            ListNode slow = head;
            ListNode fast = head;
            // 链表为奇数时, slow 指向中心点, fast 指向 最后一个元素
            // 链表为偶数时, 指向靠右的中心点, fast 指向 null
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 如果是奇数, 则slow后移一位, 翻转要避开中心点
            if (fast != null) {
                slow = slow.next;
            }
            // 这里fast指向第二个链表头节点
            // 进行翻转, 翻转后的头结点
            slow = reserve(slow);
            // 进行判断
            return compare(head, slow);
        }

        /**
         * 比较分为俩种情况
         * 总链表长度为偶数, slow节点数 = fast节点数
         * 奇数, fast少一个节点
         * @param slow
         * @param fast
         * @return
         */
        private boolean compare(ListNode slow, ListNode fast) {
            ListNode p = slow;
            ListNode q = fast;
            while (q != null) {
                if (q.val != p.val) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
            return true;
        }

        private ListNode reserve(ListNode listNode) {
            ListNode pre = null;
            ListNode next = null;
            ListNode p = listNode;
            while(p != null) {
                next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        new Question234().new Solution().isPalindrome(
                new ListNode(1,new ListNode(2, new ListNode(
                        2, new ListNode(1)))));
    }
}
