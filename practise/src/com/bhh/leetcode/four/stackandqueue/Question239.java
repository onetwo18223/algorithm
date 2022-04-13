package com.bhh.leetcode.four.stackandqueue;

import java.util.ArrayDeque;

/**
 * @author bhh
 * @description 滑动窗口最大值
 * @date Created in 2022-03-04 21:59
 * @modified By
 */
public class Question239 {
    class Solution {
        /*
        使用单调队列, 单调递减, 每次存数据判断是否是最大值
        getFirst() 获取最大值
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
                int left = i - k + 1;
                if (left >= 0) {
                    int remove = left - 1;
                    if (deque.getFirst() == remove) {
                        deque.removeFirst();
                    }
                    res[left] = nums[deque.getFirst()];
                }
            }
            return res;
        }
    }
}
