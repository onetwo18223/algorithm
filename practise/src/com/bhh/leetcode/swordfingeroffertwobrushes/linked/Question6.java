package com.bhh.leetcode.swordfingeroffertwobrushes.linked;

import java.util.ArrayDeque;

import java.util.Deque;
/**
 * @author bhh
 * @description 从尾到头打印链表
 * @date Created in 2022-01-15 13:02
 * @modified By
 */
public class Question6 {
    class Solution {
        /*
        方法一 : 使用辅助栈
        方法二 : 使用后序遍历
         */
        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            Deque<Integer> stack = new ArrayDeque<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int len = stack.size();
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = stack.pop();
            }
            return res;
        }
    }
}
