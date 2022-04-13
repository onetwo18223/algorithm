package com.bhh.leetcode.hot100twobrushes.linked.ring;

import com.bhh.leetcode.hot100twobrushes.linked.ListNode;

/**
 * @author bhh
 * @description 环形链表 II
 * @date Created in 2022-01-11 21:35
 * @modified By
 */
public class Question142 {
    public class Solution {
        /*
        要求返回环形开始的点
         */
        public ListNode detectCycle(ListNode head) {
            ListNode start = head;
            ListNode end = head;
            // 结束条件为 start == end, 寻找到了环
            while (true) {
                if (end == null || end.next == null) {
                    return null;
                }
                start = start.next;
                end = end.next.next;
                if (start == end) {
                    break;
                }
            }

            // head指针开始向后遍历, start/end指针向前遍历, 若相遇则是环的入口
            while (head != start) {
                head = head.next;
                start = start.next;
            }
            return head;
        }
    }
}
