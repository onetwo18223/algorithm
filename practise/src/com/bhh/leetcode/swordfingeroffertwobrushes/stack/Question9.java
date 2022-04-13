package com.bhh.leetcode.swordfingeroffertwobrushes.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 用两个栈实现队列
 * @date Created in 2022-01-20 11:30
 * @modified By
 */
public class Question9 {
    /*
    使用俩个stack实现队列
     */
    class CQueue {
        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        // 添加数据时向 stack1 中添加
        public void appendTail(int value) {
            stack1.push(value);
        }

        // 删除数据时, 若stack2为空, 则将stack1中数据转移到stack2
        // 若stack2有数据, 则移除首位
        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                if (stack1.isEmpty()) {
                    return -1;
                } else {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    return stack2.pop();
                }
            }
        }
    }
}
