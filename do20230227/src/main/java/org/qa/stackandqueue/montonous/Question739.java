package org.qa.stackandqueue.montonous;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 每日温度
 * https://leetcode.cn/problems/daily-temperatures/
 * 实现：
 * 单调栈实现
 * @Author Bhh
 * @Date 2023-03-31 16:21
 * @Version 1.0
 */
public class Question739 {
    class Solution {
        public int[] dailyTemperatures(int[] nums) {
            if (null == nums || nums.length == 0) return new int[]{};
            int len = nums.length;
            int[] res = new int[len];
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = 0; i < len; i++) {
                while(!stack.isEmpty() && nums[stack.getFirst()] < nums[i]) {
                    Integer tmp = stack.removeFirst();
                    res[tmp] = i - tmp;
                }
                stack.addFirst(i);
            }
            while(!stack.isEmpty()) {
                res[stack.removeFirst()] = 0;
            }
            return res;
        }
    }
}
