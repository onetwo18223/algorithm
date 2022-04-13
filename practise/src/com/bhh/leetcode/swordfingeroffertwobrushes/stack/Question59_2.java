package com.bhh.leetcode.swordfingeroffertwobrushes.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author bhh
 * @description 队列的最大值
 * @date Created in 2022-01-20 12:15
 * @modified By
 */
public class Question59_2 {
    /*
    问题在于如何实现O(1)复杂度的获取最大值
    若是单纯维护一个最大值队列, 那么获取了第一个最大值则无法获取第二个最大值
    那么若是维护一个最大值栈, 同样也是存在着获取了第一个最大值则无法获取第二个最大值问题
    又若是维护一个最小值栈, 那么问题就又出在了无法获取栈底元素
    综合考虑使用 双端队列, 单调递减的双端队列(最大值在deque的队首)
     */
    class MaxQueue {
        // 存储最大值
        private Deque<Integer> deque;
        // 充当队列
        private Queue<Integer> queue;

        public MaxQueue() {
            deque = new ArrayDeque<>();
            queue = new ArrayDeque<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.getFirst();
        }

        // 添加数据
        // queue添加数据到队列头
        // deque从尾部开始移除所有小于value的数值, 因为越是新进的数存活时间越长
        public void push_back(int value) {
            queue.add(value);
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.removeLast();
            }
            deque.addLast(value);
        }

        // 移除队首数据
        // 判断deque的队首元素(最大元素)是否是要删除元素
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int tmp = queue.remove();
            if (!deque.isEmpty() && tmp == deque.getFirst()) {
                deque.removeFirst();
            }
            return tmp;
        }
    }
}
