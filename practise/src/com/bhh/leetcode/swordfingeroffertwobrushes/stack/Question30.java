package com.bhh.leetcode.swordfingeroffertwobrushes.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 包含min函数的栈
 * @date Created in 2022-01-20 11:44
 * @modified By
 */
public class Question30 {
    /*
    最小值栈, 最大值队列
    最小值栈使用俩个栈完成
    最小栈可以使用俩个栈完成是因为栈先进后出,
        那么后进的一个小值, 无论在stack1还是stack2同样会先出
        同理先进的小值, 俩个栈也都是等前面的数出栈才可以出栈
        越是新进的数存活时间越短
     */
    class MinStack {
        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        /*
        添加数值时, 判断x和stack2.peek()值
        若是stack2.isEmpty() || x <= stack2.peek(), 则同时添加x到stack2
         */
        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || x <= stack2.peek()) {
                stack2.push(x);
            }
        }

        /*
        若是删除的数等于stack2.peek(), 则同时stack2.pop()
         */
        public void pop() {
            int tmp = stack1.pop();
            if (!stack2.isEmpty() && tmp == stack2.peek()) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.isEmpty() ? -1 : stack1.peek();
        }

        public int min() {
            return stack2.isEmpty() ? -1 : stack2.peek();
        }
    }
}
