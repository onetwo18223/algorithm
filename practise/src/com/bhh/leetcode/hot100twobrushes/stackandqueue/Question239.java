package com.bhh.leetcode.hot100twobrushes.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 滑动窗口最大值
 * @date Created in 2022-01-22 20:53
 * @modified By
 */
public class Question239 {
    class Solution {
        /*
        使用双端队列, 单调递减, 队首元素是最大的
        遍历添加元素, 每次添加元素都需要移除队尾中小于该元素的元素
        若是形成了窗口则记录
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                // 队尾移除小于nums[i]的元素
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
                // 比较队首和left, 判断是否过期
                int left = i - k + 1;
                if (deque.getFirst() < left) {
                    deque.removeFirst();
                }
                // 若是已经形成了窗口, 则记录最大值(队首元素)
                if (left >= 0) {
                    res[left] = nums[deque.getFirst()];
                }
            }
            return res;
        }
    }
}
