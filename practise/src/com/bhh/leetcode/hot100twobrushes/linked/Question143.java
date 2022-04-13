package com.bhh.leetcode.hot100twobrushes.linked;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 重排链表
 * @date Created in 2022-02-03 13:48
 * @modified By
 */
public class Question143 {
    class Solution {
        /*
        需要原地排序
        那么需要从中点向结束点之间的节点存储在栈中
        再次遍历链表, 每遍历一个节点, 则在其后添加一个栈顶节点, 进行重构
         */
        public void reorderList(ListNode head) {
            // 双指针寻找中点
            ListNode slow = head;
            ListNode fast = head;
            // 结束
            // 奇数 指向中心点
            // 偶数 指向中心靠左
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Deque<ListNode> stack = new ArrayDeque<>();
            // 添加节点到栈, 添加到栈的节点不要出现在原来链表上
            ListNode end = slow;
            while (slow != null && slow.next != null) {
                slow = slow.next;
                stack.addFirst(slow);
            }
            end.next = null;

            // 进行重构
            ListNode p = head;
            while (!stack.isEmpty()) {
                ListNode node = stack.removeFirst();
                node.next = p.next;
                p.next = node;
                p = p.next.next;
            }
        }
    }
}
