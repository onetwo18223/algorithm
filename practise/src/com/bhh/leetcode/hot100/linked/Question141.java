package com.bhh.leetcode.hot100.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 环形链表
 * @date Created in 2021-12-23 14:41
 * @modified By
 */
public class Question141 {
    public class Solution {
        /*
        求是否有环
        对于这道题, 其实Hash表是一个很好地解决
         */
        public boolean hasCycleWithHash(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            ListNode node = head;
            while (node != null){
                node = node.next;
                if (set.contains(node)){
                    return true;
                }
                set.add(node);
            }
            return false;
        }

        /*
        循环链表的标准一点做法是使用快慢双指针, 快指针一步跨俩, 慢指针一步跨一
        如果相遇表示有环,
        没有相遇且 快指针 == null || 快指针.next == null, 表示没环
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null){
                return false;
            }
            ListNode start = head;
            ListNode end = head.next;
            while (start != end){
                if (end == null || end.next == null){
                    return false;
                }
                start = start.next;
                end = end.next.next;
            }
            return true;
        }
    }
}
