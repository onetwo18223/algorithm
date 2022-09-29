package org.problem.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用队列实现栈
 * <p>
 * w双队列实现：栈是先进后出，而队列是先进先出，要让队列先进后出，
 * 需要使用一个队列存储之前的数据queue2，另一个存储最新的数据queue1，
 * 因为俩个队列都是先进先出，所以类似于栈实现队列的方法是行不通的
 * 想要实现先进后出，要将之前存储的数据都放在新数据前面，这样就可以保证先进后出
 * 具体实现为queue1存储新数据，之后将queue2的数据转移到queue1，
 * 那么就可以实现先进后出
 * <p>
 * 单队列实现：
 */
public class Question225 {
    class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void push(int x) {
            // 添加元素到队列
            queue1.offer(x);
            // 栈是先进后出，而队列是先进先出，要让队列先进后出，
            // 需要使用一个队列存储之前的数据queue2，另一个存储最新的数据queue1，
            // 然后将queue2的数据转移到queue1中
            while (!queue2.isEmpty())
                queue1.offer(queue2.poll());
            // 交换
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue2.poll();
        }

        public int top() {
            return queue2.peek();
        }

        public boolean empty() {
            return queue2.isEmpty();
        }
    }
}
