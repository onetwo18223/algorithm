package com.bhh.leetcode.headquarters;

/**
 * @author bhh
 * @description 翻转链表
 * 翻转链表不需要改变节点
 * 而是改变next指向
 * 实现思路
 *      维护
 *          变量 pre 上一个节点
 *          变量 cur 当前节点
 *          变量 next 下一个节点
 *
 * @date Created in 2021-08-25 14:20
 * @modified By
 */
public class LinkedListFlip {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                str.append(node.val + "->");
                node = node.next;
            }
            str.append("NULL");
            return str.toString();
        }
    }

    public ListNode ReverseList(ListNode head) {

        ListNode node = head;
        ListNode pre = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            // 翻转
            node.next = pre;
            // 存储
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkedListFlip list = new LinkedListFlip();
        ListNode listNode = list.new ListNode(123);
        listNode.next = list.new ListNode(456);
        listNode.next.next = list.new ListNode(789);
        System.out.println(listNode);
        listNode = list.ReverseList(listNode);
        System.out.println(listNode);
    }
}
