package org.problem.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最小栈
 *
 * 实现：需要俩个栈，一个stack1用于存储数据，另一个stack2用于存储最小值
 * 若是出栈stack1.pop（），则判断出栈元素是否是最小值（stack2.peek（））
 * 如果是，则stack2.pop（）
 */
public class Question155 {
    class MinStack {
        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public MinStack() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int val) {
            stack1.push(val);
            if (stack2.isEmpty() || stack2.peek() >= val) stack2.push(val);
        }

        // pop、top 和 getMin 操作总是在 非空栈 上调用
        public void pop() {
            if (!stack2.isEmpty()
                    && stack1.pop().equals(stack2.peek()))
                stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }
}
