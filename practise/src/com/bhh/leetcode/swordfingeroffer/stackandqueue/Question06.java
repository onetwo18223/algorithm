package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import javax.xml.stream.events.NotationDeclaration;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bhh
 * @description 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @date Created in 2021-09-20 15:28
 * @modified By
 */
public class Question06 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        /*
        实现思路 :
        从尾到头打印链表
        方法一 : 将链表遍历一遍, 存储到栈中, 然后遍历栈输出
        方法二 : 递归法, 遍历节点, 每层 深入, 回溯 的时候添加Node节点的val到list, 然后toArray()返回数组
         */
        public int[] reversePrint1(ListNode head) {
            if (head == null){
                return new int[0];
            }
            Stack<ListNode> stack = new Stack<>();

            ListNode i = head;
            int sum = 0;
            while (i != null) {
                stack.push(i);
                sum++;
                i = i.next;
            }
            int[] nums = new int[sum];
            for (int j = 0; j < sum; j++) {
                nums[j] = stack.pop().val;
            }
            return nums;
        }
        public int[] reversePrint2(ListNode head) {
            if (head == null){
                return new int[0];
            }
            List<Integer> list = new ArrayList<>();
            reversePrint2(head, list);
            int[] nums = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(i);
            }
            return nums;
        }

        void reversePrint2(ListNode node, List list){
            if (node == null){
                return;
            }
            reversePrint2(node.next, list);
            list.add(node.val);
        }
    }
}
