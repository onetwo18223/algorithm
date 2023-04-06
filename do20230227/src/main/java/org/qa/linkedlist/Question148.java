package org.qa.linkedlist;

/**
 * @Desc 排序链表
 * https://leetcode.cn/problems/sort-list/
 * 实现：
 *
 * @Author Bhh
 * @Date 2023-04-03 10:47
 * @Version 1.0
 */
public class Question148 {
    {
        /* 实现：
        对应链表来说，可以使用递归的排序方法是最适合的
        归并排序和快速排序的选择
         快速排序有大量的重拍交换步骤
         归并排序整体进行了重拍
        所以归并相对更适合链表
         */
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            // TODO: 在归并排序中递归结束条件为：left >= right，
            //  而在链表中，没有left与right这俩个索引，在链表中，循环遍历到结尾结束
            //  所以他的结束也需要变成 null == head || null == head.next
            if (null == head || null == head.next) return head;
            // 寻找中点
            ListNode mid = this.findMid(head);
            ListNode next = mid.next;
            mid.next = null;
            ListNode left = this.sortList(head);
            ListNode right = this.sortList(next);
            return this.merge(left, right);
        }

        /**
         * @Author Bhh
         * @Desc 合并俩个链表
         * @Param [left, right]
         * @Return org.qa.linkedlist.ListNode
         **/
        private ListNode merge(ListNode left, ListNode right) {
            if (null == left) return right;
            if (null == right) return left;
            if (left.val > right.val) {
                right.next = merge(left, right.next);
                return right;
            }
            left.next = merge(left.next, right);
            return left;
        }

        /**
         * @Author Bhh
         * @Desc 获取链表中心点，使用快慢双指针
         * @Param [head]
         * @Return org.qa.linkedlist.ListNode
         **/
        private ListNode findMid(ListNode head) {
            if (null == head) return head;
            ListNode slow = head;
            ListNode fast = head.next;
            // TODO: 若是slow和fast同一起点，则获取到的中心点是偏右的
            //  如果有俩个元素，则无法使用该方法分开元素，例如：
            // 1 2 = 2
            // 1 2 3 = 2
            // 1 2 3 4 = 3
            // TODO: 若是fast = head.next，则获取到的中心点是偏左的
            // 1 2 = 1
            // 1 2 3 = 2
            // 1 2 3 4 = 2
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
