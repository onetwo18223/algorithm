package com.bhh.leetcode.four.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 每日温度
 * @date Created in 2022-03-03 21:58
 * @modified By
 */
public class Question739 {
    class Solution {
        /*
        本题使用的单调栈, 单调递减栈
        单调栈存储的一般都是索引
        需要注意结尾的0
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            int[] res = new int[len];
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = 0; i < len; i++) {
                // 如果栈不为空, 且栈顶元素较小, 则出栈元素
                // 对于出栈的元素来说i索引元素是对于出栈元素的最近较大元素
                while ((!stack.isEmpty()) &&
                        temperatures[stack.peek()] < temperatures[i]) {
                    int tmp = stack.pop();
                    res[tmp] = i - tmp;
                }
                stack.push(temperatures[i]);
            }
            return res;
        }
    }
}
