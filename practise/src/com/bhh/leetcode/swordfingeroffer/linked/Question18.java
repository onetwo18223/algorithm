package com.bhh.leetcode.swordfingeroffer.linked;

/**
 * @author bhh
 * @description 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 题目保证链表中节点的值互不相同
 * @date Created in 2021-09-24 8:39
 * @modified By
 */
public class Question18 {
    /**
     * Definition for singly-linked list.
     */
    class Solution {
        /*
        实现思路 : 先判断头结点是不是目标节点, 不是则遍历链表, 用上一个结点来判断下一个节点是不是需要删除
         */
        public ListNode deleteNode(ListNode head, int val) {
            // 判断头结点
            if (head.val == val) {
                return head.next;
            }

            // 遍历节点
            ListNode p = head;
            // 先要判断p是否为null, 否则p.next很可能报空指针
            while (p != null && p.next != null) {
                if (p.next.val == val) {
                    p.next = p.next.next;
                }
                p = p.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {

        ListNode test = LinkedUtil.getInstance(new int[]{
                -3, 5, -99
        });
//        LinkedUtil.OutListNode(test);
        LinkedUtil.OutListNode(new Question18().new Solution().deleteNode(test, -99));
        ;
    }
}
