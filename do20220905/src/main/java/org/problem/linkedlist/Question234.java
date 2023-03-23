package org.problem.linkedlist;

/**
 * 回文链表
 *
 * 回文串一般使用相向双指针和背向双指针
 * 但是因为是链表所以无法完成不同方向的遍历
 * 而 时间复杂度O(n)和空间复杂度O(1) 必须要使用双指针
 * 所以我们需要将链表结构进行更改
 * 寻找中间点, 对一半链表进行反转, 之后再进行双指针比对
 * 翻转前：1->2->3->4->null
 * 翻转后：null<-1<-2 3->4->null
 * 翻转前：1->2->3->4->5->null
 * 翻转后：null<-1<-2<-3 4->5->null
 */
public class Question234 {
    class Solution {
        // 链表节点数
        int sum = 1;
        public boolean isPalindrome(ListNode head) {
            if (head == null) return false;
            // 获取中间靠左节点，获取左节点是为了让链表中间断开，
            // 让slow.next == null即可
            // 同时获取中间靠右节点，为了方便背向双指针遍历
            // 通过sum总结点数判断奇偶
            ListNode slow = getMid(head), right = slow.next;
            // 翻转，并且需要链表从中间断开
            slow = reserve(head, slow);
            // 如果总结点数是奇数，则向前一位，之后进行回文判断
            if (sum % 2 != 0) slow = slow.next;
            return palindromeJudge(slow, right);
        }

        /**
         * 从俩个节点开始背向遍历判断回文串
         * @param left
         * @param right
         * @return
         */
        private boolean palindromeJudge(ListNode left, ListNode right) {
            while(left != null && right != null) {
                if (left.val != right.val) return false;
                left = left.next;
                right = right.next;
            }
            return left == null && right == null;
        }

        /**
         * 链表翻转， 并让链表整体从中间断开
         * @param head
         * @return
         */
        private ListNode reserve(ListNode head, ListNode node) {
            // 断开链接
            node.next = null;

            ListNode pre = null, next = null;
            while(head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

        /**
         * 获取中间节点数
         * @param head
         * @return
         */
        private ListNode getMid(ListNode head) {
            ListNode fast = head, slow = head;
            while(fast.next != null) {
                if (fast.next.next == null) {
                    // fast.next不为空，fast.next.next为空，表示只有一个节点
                    sum += 1;break;
                }
                slow = slow.next;
                fast = fast.next.next;
                sum += 2;
            }
            return slow;
        }
    }
}
