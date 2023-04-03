package org.qa.linkedlist;


/**
 * @Desc 链表问题
 * 链表因为其数据结构，所以和递归高度契合（遍历的另一种形式）（递归需要注意前序中序后序）
 * @Author Bhh
 * @Date 2023-04-03 9:24
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}