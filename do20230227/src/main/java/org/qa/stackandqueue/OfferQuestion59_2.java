package org.qa.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 队列的最大值
 * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 * 实现：
 * 队列 + 双端队列
 * 队列正常添加数据，
 * 双端队列必须保证是单调递增形式，也就是说他只会存储大数+其序列后的小数，
 * 若他之后有大数进入队列，则会删除之前的小数，若改大数之后有小数进入，则仍然保存
 * @Author Bhh
 * @Date 2023-03-30 16:51
 * @Version 1.0
 */
public class OfferQuestion59_2 {
    class MaxQueue {

        private Deque<Integer> queue;
        private Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new ArrayDeque<Integer>();
            maxQueue = new ArrayDeque<Integer>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.getLast();
        }

        public void push_back(int value) {
            queue.addFirst(value);
            while (!maxQueue.isEmpty() && maxQueue.getFirst().compareTo(value) < 0)
                maxQueue.removeFirst();
            maxQueue.addFirst(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            Integer last = queue.removeLast();
            if (last.equals(maxQueue.getLast())) {
                maxQueue.removeLast();
            }
            return last;
        }
    }
}
