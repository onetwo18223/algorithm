package org.problem.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 队列的最大值
 * <p>
 * 实现：不同于双栈实现，我记得这个需要双端队列
 * 创建俩个队列，一个队列queue1用于存储数据信息，另一个队列queue2用于存储最大值
 * 但是队列不同于栈，可以存储最大值，第二大值，第三大值等等
 * 所以我们需要一个双端队列
 * queue1存储数据时，queue2需要从队列尾部弹出小于该数据的元素，
 * 让queue2可以保持从头到尾是递减的
 *
 * 使用ArrayDeque最好使用 addLast()（添加结点一般都是在尾部添加） removeFirst() 或者 removeLast() ，
 *      方便自己建造队列或者栈
 *
 */
public class InterViewQuestion59_2 {
    class MaxQueue {
        private Deque<Integer> queue1;
        private Deque<Integer> queue2;

        public MaxQueue() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public int max_value() {
            return queue2.isEmpty() ? -1 : queue2.getFirst();
        }

        public void push_back(int value) {
            queue1.addLast(value);
            if (queue2.isEmpty()) queue2.addLast(value);
            else {
                // 保证queue2单调递减
                while (!queue2.isEmpty() && queue2.getLast() < value)
                    queue2.removeLast();
                queue2.addLast(value);
            }
        }

        public int pop_front() {
            if (queue1.isEmpty()) return -1;
            Integer pop = queue1.removeFirst();
            if (pop.equals(queue2.getFirst()))
                queue2.removeFirst();
            return pop;
        }
    }
}
