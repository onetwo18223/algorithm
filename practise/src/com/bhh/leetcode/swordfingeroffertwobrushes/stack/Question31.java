package com.bhh.leetcode.swordfingeroffertwobrushes.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 栈的压入、弹出序列
 * @date Created in 2022-01-12 22:48
 * @modified By
 */
public class Question31 {
    class Solution {
        /*
        模拟
         */
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque();
            int pushIndex = 0, popIndex = 0;
            while (pushIndex < pushed.length && popIndex < popped.length) {
                stack.push(pushed[pushIndex]);
                while (!stack.isEmpty() && popIndex < popped.length
                        && stack.peek() == popped[popIndex]) {
                    stack.pop();
                    popIndex++;
                }
                pushIndex++;
            }
            return popIndex >= popped.length - 1;
        }
    }
}
