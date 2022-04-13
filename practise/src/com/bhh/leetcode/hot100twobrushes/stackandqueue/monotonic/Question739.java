package com.bhh.leetcode.hot100twobrushes.stackandqueue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 每日温度
 * @date Created in 2022-01-21 21:08
 * @modified By
 */
public class Question739 {
    class Solution {
        /*
        求最近的比这个元素大的元素
        单调递减栈 栈底最大 栈顶最小
        每次出栈, 都可以找到出栈元素的最近较大值(入栈元素)
         */
        public int[] dailyTemperatures(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] array = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int tmp = stack.pop();
                    array[tmp] = i - tmp;
                }
                stack.push(i);
            }
            return array;
        }
    }

}
