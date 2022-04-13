package com.bhh.leetcode.swordfingeroffer.linked;

import com.bhh.leetcode.swordfingeroffer.stackandqueue.Question59_1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bhh
 * @description 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @date Created in 2021-09-24 14:31
 * @modified By
 */
public class Question52 {
    public class Solution {
        /*
        实现思路 : 求公共节点, 其实就是求重复元素, 重复元素首先想到了HashMap
        遍历链表headA, 将节点存放在map中, key为节点, value为1
        遍历链表headB, 若是出现了相同的key, 则value + 1, 总数sum + 1,
            //复杂版 : 若之后出现的key发现有没有存储在map中的(另一个值相等的节点, 并不是同一节点), 则重置sum
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            ListNode res = null;
            ListNode p1 = headA;
            ListNode p2 = headB;
            while (p1 != null) {
                set.add(p1);
                p1 = p1.next;
            }
            while (p2 != null) {
                // 添加失败
                if (set.contains(p2)) {
                    res = p2;
                }
                p2 = p2.next;
            }
            return res;
        }
    }
}
