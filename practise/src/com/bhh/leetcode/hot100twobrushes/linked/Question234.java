package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 回文链表
 * @date Created in 2022-01-23 13:35
 * @modified By
 */
public class Question234 {
    class Solution {
        /*
        判断是否是回文数
        题目要求O(1)的空间复杂度, 所以不可以使用栈
        方法一 : 快慢双指针 + 翻转
        需要找前半段的结束点, 使用到了快慢双指针的方法
        方法二 : 递归, 类似于后序遍历
         */
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            // 1  2  2  1         1  2  1
            // ij i  i     j
            // 结束 slow指向中间位置或者是对称靠右的位置
            // fast指向最后一位不为空的节点
            // 如果fast结束指向了null, 表示是偶数
            // 若fast结束指向的不是null, 表示是奇数
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 如果数量是奇数, 则slow++;(翻转跳过奇数中心点)
            if (fast != null) {
                slow = slow.next;
            }
            // 翻转
            slow = reserve(slow);
            // 比较
            return compare(slow, head);
        }

        /**
         * 比较
         * @param slow 第二段, 链表长度为奇数时, 第二段会少一个元素
         * @param head 第一段
         * @return
         */
        private boolean compare(ListNode slow, ListNode head) {
            ListNode p = head;
            ListNode q = slow;
            // 若是链表为奇数, 则前半段长度大于后半段, 所以只比较后半段即可
            while (q != null) {
                if (q.val != p.val) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
            return true;
        }

        /**
         * 翻转
         * @param slow
         */
        private ListNode reserve(ListNode slow) {
            ListNode p = slow;
            ListNode pre = null;
            ListNode next = null;
            while (p != null) {
                next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }
    }
}
