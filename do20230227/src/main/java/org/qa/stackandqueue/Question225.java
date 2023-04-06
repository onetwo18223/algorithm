package org.qa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * @Author Bhh
 * @Date 2023-03-31 13:57
 * @Version 1.0
 */
public class Question225 {
    {
        /* 实现：
        队列：先进先出 栈：先进后出
        直接使用队列先进先出的特性无法组成栈，因为永远都是先进先出
        需要使用俩个队列将数组进行互倒
         */
    }
    class MyStack {

        private Deque<Integer> queue1;
        private Deque<Integer> queue2;
        public MyStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void push(int x) {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                queue1.addFirst(x);
            } else if (queue1.isEmpty()) {
                queue1.addFirst(x);
                while(!queue2.isEmpty())
                    queue1.addFirst(queue2.removeLast());
            } else {
              queue2.addFirst(x);
              while(!queue1.isEmpty())
                  queue2.addFirst(queue1.removeLast());
            }
        }

        public int pop() {
            return queue1.isEmpty() && queue2.isEmpty() ?
                    -1 : (queue1.isEmpty() ? (queue2.removeLast()) : (queue1.removeLast()));

        }

        public int top() {
            return queue1.isEmpty() && queue2.isEmpty() ?
                    -1 : (queue1.isEmpty() ? (queue2.getLast()) : (queue1.getLast()));
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
