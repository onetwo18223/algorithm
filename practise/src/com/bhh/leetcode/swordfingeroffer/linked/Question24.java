package com.bhh.leetcode.swordfingeroffer.linked;

import com.bhh.leetcode.swordfingeroffer.stackandqueue.Question59_1;

/**
 * @author bhh
 * @description 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @date Created in 2021-09-24 13:52
 * @modified By
 */
public class Question24 {
    class Solution {
        /*
        实现思路 : 反转列表如果是使用了俩个链表空间就十分简单, 但是一个空间也可以实现
        如果使用一个空间, 使用的方法不是赋值覆盖而是改变链表指向, 只需要改变指向就是结果
        遍历链表,
        需要存储的信息 : next(下一个需要遍历的节点), p(当前节点), pre(前一个节点, 反转后将next指向pre节点)
        返回最后的节点
         */
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode p = head;
            ListNode next = p.next;
            ListNode pre = null;

            while (p != null) {
                /*
                这段逻辑特点 : 都是先用, 用完再赋值, 而且遍历链表, 一般都是遍历点最后被修改
                 */
                next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        LinkedUtil.OutListNode(
                new Question24().new Solution().reverseList(
                        LinkedUtil.getInstance(new int[]{
                                1, 2, 3, 4, 5
                        })));

    }
}
