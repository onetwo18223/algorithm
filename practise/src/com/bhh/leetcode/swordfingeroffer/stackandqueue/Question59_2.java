package com.bhh.leetcode.swordfingeroffer.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author bhh
 * @description 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * <p>
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:[null,-1,-1]
 * @date Created in 2021-09-21 12:40
 * @modified By
 */
public class Question59_2 {
    /*
    实现思路 : 参照于实现 最小值栈
    push_back() 方法需要另一个集合辅助, 存储数据时判断这个数据是不是大于集合首位, 若大于等于, 则存储, 否则不存储
    pop_front() 方法除了删除队列中的数据, 还需要判断要删除的数据和集合首位数据是否相同, 相同则删除
    max_value() 方法返回集合首位元素
     */
    class MaxQueue {

        private Queue<Integer> queue;
        private Stack<Integer> stack;

        public MaxQueue() {
            queue = new ConcurrentLinkedQueue<>();
            stack = new Stack<>();
        }

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        /*
        步骤 :
        添加数据到queue
        若stack为空 或 stack.get(0) <= value, 存储数据
         */
        public void push_back(int value) {
            queue.add(value);
            if (stack.isEmpty() || stack.peek() <= value) {
                stack.push(value);
            }
        }

        /*
        步骤 :
        删除queue顶的数据
        若stack.size() != 0 且 stack.peek(0) == value, 则也要删除stack首位元素
         */
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            Integer remove = queue.remove();
            if ((!stack.isEmpty()) && remove.equals(stack.peek())) {
                stack.pop();
            }
            return remove;
        }
    }

    public static void main(String[] args) {
        MaxQueue test = new Question59_2().new MaxQueue();
        test.push_back(1);
        test.push_back(2);
        System.out.println(test.max_value());
        System.out.println(test.pop_front());
        System.out.println(test.max_value());
        System.out.println(test.pop_front());
        System.out.println(test.max_value());
    }
}
