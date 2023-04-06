package org.qa.linkedlist;

/**
 * @Desc 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 * @Author Bhh
 * @Date 2023-04-04 9:20
 * @Version 1.0
 */
public class Question234 {
    {
        /* 实现：
        判断是否是回文链表
        寻找靠右中心点
        将前半段链表翻转
        进行遍历判断是否是回文链表
         */
    }
    class Solution {
        private int sum = 0;
        public boolean isPalindrome(ListNode head) {
            if (null == head) return true;
            // 获取靠左中心点
            ListNode leftCenter = this.getMidBetter(head);
            System.out.println(sum);
            ListNode rightList = leftCenter.next;
            leftCenter.next = null;
            // 翻转前半段
            head = this.reserve(head);
            // 如果是奇数则向前推进一格
            if (sum % 2 == 1) head = head.next;
//            System.out.println(head.val);
//            System.out.println(rightList.val);
            // 判断是否是回文串
            return this.isPalindrome(head, rightList);
        }

        private boolean isPalindrome(ListNode left, ListNode right) {
            while((left != null && right != null) && (left.val == right.val)) {
                left = left.next;
                right = right.next;
            }
            return left == null && right == null;
        }

        /**
         * @Author Bhh
         * @Desc 原地翻转
         * @Param [head]
         * @Return void
         **/
        private ListNode reserve(ListNode head) {
            ListNode pre = null, next;
            while(head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

        /**
         * @Author Bhh
         * @Desc 通过快慢双指针获取中心点（靠右） 且 获取总结点数sum
         * @Param [node]
         * @Return org.qa.linkedlist.ListNode
         **/
        // TODO:如何兼顾查询节点数和获取中心点
        //  如果是用常规的 `while(fast != null && fast.next != null) `来进行查询
        //  该方法可以获取中心点但是对于计算节点数来说较为麻烦，因为涉及循环前，循环结束后的情况处理
        //  更好地方法是使用 `while(fast.next != null || fast.next.next != null)` 来完成查询
        //  该方法可以在获取中心点的同时(获取到的是靠左中心点，因为这种方法可以看做是向前移动了一步)
        //  而且涉及计算节点数来说较为好整理，因为循环条件和循环体的逻辑一样，所以比较好处理特殊情况（当fast.next.next == null时， sum += 1;）
        private ListNode getMid(ListNode node) {
            ListNode slow = node;
            // 当fast = node.next 时得到的slow是靠左中心点
            // 当fast = node 时得到的slow是靠右中心点
            ListNode fast = node.next;

            // 计算节点数循环前处理
            if (fast != null && fast.next == null) sum += 2;
            else sum++;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                sum += 2;
                // 计算节点数循环后处理
                if (fast != null && fast.next == null) {
                    sum += 1;
                }
            }
            return slow;
        }

        /**
         * @Author Bhh
         * @Desc 使用 while(fast.next != null || fast.next.next != null)
         * @Param [node]
         * @Return org.qa.linkedlist.ListNode
         **/
        private ListNode getMidBetter(ListNode node) {
            ListNode slow = node;
            ListNode fast = node;
            // 因为是从node开始，计算头结点
            sum++;
            while(fast.next != null) {
                if (fast.next.next == null) {
                    sum++;break;
                }
                slow = slow.next;
                fast = fast.next.next;
                sum += 2;
            }
            return slow;
        }
    }
}
