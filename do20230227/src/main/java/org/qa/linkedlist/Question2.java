package org.qa.linkedlist;

/**
 * @Desc 两数相加
 * https://leetcode.cn/problems/add-two-numbers/

 * @Author Bhh
 * @Date 2023-04-03 9:24
 * @Version 1.0
 */
public class Question2 {
    {
        /* 实现：
        递归相加链表的俩个节点
        若是一方为null则直接返回
        需要参数P记录进位
         */
    }
    class Solution {
        int p = 0;
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (null == l1 || null == l2) return null;
            return this.recursion(l1, l2);
        }

        private ListNode recursion(ListNode l1, ListNode l2) {
            // TODO:递归结束条件
            //  如果进位到最后，p仍然为1，则需要再添加一位存储p
            //  且当有节点位null时，不能直接返回另一个节点，因为还有进位需要进位
            if (null == l1 && null == l2 && p == 1) return new ListNode(p);
            else if (null == l1 && null == l2) return null;

            int value;
            if (null == l1) value = l2.val + p;
            else if (null == l2) value = l1.val + p;
            else value = l1.val + l2.val + p;

            if (value >= 10) {
                p = 1;
                value = value % 10;
            } else {
                p = 0;
            }
            ListNode node = new ListNode(value);
            node.next = recursion(null == l1 ? null : l1.next,
                    null == l2 ? null : l2.next);
            return node;
        }
    }
}
