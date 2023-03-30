package org.qa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 最小栈
 * https://leetcode.cn/problems/min-stack/
 * 实现：
 * 使用俩个栈实现，
 * 一个用于正常存储数据，
 * 另一个用于存储最小值
 * @Author Bhh
 * @Date 2023-03-30 15:07
 * @Version 1.0
 */
public class Question155 {
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;
        public MinStack() {
            stack = new ArrayDeque<Integer>();
            minStack = new ArrayDeque<Integer>();
        }

        public void push(int val) {
            stack.addFirst(val);
            if (minStack.isEmpty() || val <= minStack.getFirst())
                minStack.addFirst(val);
        }

        public void pop() {
            if (stack.isEmpty()) return;
            if (!minStack.isEmpty()
                    && stack.removeFirst().equals(minStack.getFirst()))
                minStack.removeFirst();
        }

        public int top() {
            return stack.getFirst();
        }

        public int getMin() {
            return minStack.getFirst();
        }
    }
}
