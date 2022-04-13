package com.bhh.leetcode.hot100.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 每日温度
 * @date Created in 2022-01-02 14:00
 * @modified By
 */
public class Question739 {
    class Solution {
        /*
        使用单调栈
        使用栈存储索引, 遍历nums, 若是当前值大于栈顶元素,
            则说明该元素是大于栈顶元素的第一个元素
         */
        public int[] dailyTemperatures(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int len = nums.length;
            int[] res = new int[len];
            Deque<Integer> stack = new ArrayDeque();
            stack.push(0);
            for (int i = 1; i < len; i++) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    int tmp = stack.pop();
                    res[tmp] = i - tmp;
                }
                stack.push(i);
            }
            return res;
        }
    }
}
