package org.qa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc  用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * 实现：
 * 队列：先进先出 栈：先进后出
 * 如果使用栈多次翻转，会造成数据顺序错乱
 * 所以栈只能翻转一次
 * 使用stack1存数，stack2取出，
 * 取数时（以取数作为翻转条件，不同于队列实现栈以添加作为翻转条件），
 *  当stack2位空时，使用stack1赋值
 * @Author Bhh
 * @Date 2023-03-31 14:14
 * @Version 1.0
 */
public class Question232 {
    class MyQueue {

        private Deque<Integer> stack1;
        private Deque<Integer> stack2;
        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.addFirst(x);
        }

        public int pop() {
            if (stack2.isEmpty())
                while (!stack1.isEmpty())
                    stack2.addFirst(stack1.removeFirst());
            return stack2.removeFirst();
        }

        public int peek() {
            if (stack2.isEmpty())
                while (!stack1.isEmpty())
                    stack2.addFirst(stack1.removeFirst());
            return stack2.getFirst();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
