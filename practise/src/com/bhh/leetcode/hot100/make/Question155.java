package com.bhh.leetcode.hot100.make;

import java.util.Stack;

/**
 * @author bhh
 * @description 最小栈
 * @date Created in 2021-12-27 18:42
 * @modified By
 */
public class Question155 {
    /*
    实现 : 通过俩个栈实现
    pop() 获取栈1栈顶元素
    push() 在添加数据时, 若是该数据是最小值, 则且将该数据添加到栈2
    getMin() 获取栈2栈顶元素
     */
    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || minStack.peek() > val) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            int del = stack.pop();
            if (del == minStack.peek()) {
                minStack.pop();
            }
        }

        public Integer top() {
            return stack.isEmpty() ? null : stack.peek();
        }

        public Integer getMin() {
            return minStack.isEmpty() ? null : minStack.peek();
        }
    }
}
