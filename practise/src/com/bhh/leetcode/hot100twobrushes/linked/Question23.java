package com.bhh.leetcode.hot100twobrushes.linked;

/**
 * @author bhh
 * @description 合并K个升序链表
 * @date Created in 2022-01-26 9:31
 * @modified By
 */
public class Question23 {
    class Solution {
        /*
        合并2个升序链表升级版
        只需要将链表进行归并划分即可
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            ListNode leftNode = merge(lists, left, mid);
            ListNode rightNode = merge(lists, mid + 1, right);
            return mergeTwoLists(leftNode, rightNode);
        }

        private ListNode mergeTwoLists(ListNode leftNode, ListNode rightNode) {
            if (leftNode == null) {
                return rightNode;
            }
            if (rightNode == null) {
                return leftNode;
            }
            ListNode node = new ListNode();
            if (leftNode.val > rightNode.val) {
                node.val = rightNode.val;
                node.next = mergeTwoLists(leftNode, rightNode.next);
            } else {
                node.val = leftNode.val;
                node.next = mergeTwoLists(leftNode.next, rightNode);
            }
            return node;
        }
    }
}
