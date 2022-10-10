package org.problem.stackandqueue.monotonous;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 */
public class Question739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            if (temperatures == null || temperatures.length == 0)
                return new int[]{};

            int length = temperatures.length;
            // 定义单调递减栈，因为是求较大值
            Deque<Integer> stack = new ArrayDeque<>();
            int[] array = new int[length];

            for (int i = 0; i < length; i++) {
                // 获取栈顶元素 索引
                // 如果栈顶元素较小，则出栈
                // 且记录出栈元素的最近较大温度在i - stackTemp天后
                while (!stack.isEmpty() &&
                        temperatures[i] > temperatures[stack.getLast()]) {
                        array[stack.getLast()] = i - stack.getLast();
                        stack.removeLast();
                }
                // 新的元素入栈
                stack.addLast(i);
            }
            // 循环结束，需要判断栈内是否还有元素
            // 对于这些元素的最近较大温度是没有的
            while (!stack.isEmpty()) {
                int index = stack.removeLast();
                array[index] = 0;
            }
            return array;
        }
    }
}
