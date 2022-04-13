package com.bhh.leetcode.three;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author bhh
 * @description 队列的最大值
 * @date Created in 2022-01-28 19:35
 * @modified By
 */
public class Question59sword {
    /*
    使用queue 充当队列, 存储元素
    使用deque 存储队列的最大值, 队首存储最大值, 每次添加数据则
        判断并抛出小于要添加的元素的队尾元素
     */
    class MaxQueue {

        private Queue<Integer> queue;
        private Deque<Integer> deque;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            deque = new ArrayDeque<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.getFirst();
        }

        /**
         * 添加元素到queue
         * 判断要添加的元素与deque队尾元素的大小, 抛出较小元素, 添加元素到deque队尾
         * @param value
         */
        public void push_back(int value) {
            queue.add(value);
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.removeLast();
            }
            deque.addLast(value);
        }

        /**
         * 抛出元素
         * queue直接抛出元素
         * deque需要判断队首元素和抛出元素的关系, 若是相等则同样抛出
         * @return
         */
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int tmp = queue.remove();
            if (tmp == deque.getFirst()) {
                deque.pop();
            }
            return tmp;
        }
    }
}
