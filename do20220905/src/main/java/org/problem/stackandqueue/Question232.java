package org.problem.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列
 *
 * 实现：队列是先进先出，而栈是后进先出，需要俩个栈，
 * 一个用于接受数据stack1，另一个用于存储数据stack2
 * 但是不能在push时，进行数据转移，
 * 是因为每次都进行数据转移（对于栈而言）会发生数据覆盖的现象
 * 所以在pop()时进行数据转移是较优选择
 *
 */
public class Question232 {
    class MyQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }
    class MyQueue1 {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public MyQueue1() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }
}
