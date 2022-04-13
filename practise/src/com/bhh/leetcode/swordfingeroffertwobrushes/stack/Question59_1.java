package com.bhh.leetcode.swordfingeroffertwobrushes.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author bhh
 * @description 滑动窗口的最大值
 * @date Created in 2022-01-20 13:02
 * @modified By
 */
public class Question59_1 {
    class Solution {
        /*
        滑动窗口最大值, 需要使用到双向队列来完成存储最大值
        单调递减, 那么每次添加数值到队列时, 需要先删除小于该元素的队尾元素
        添加该元素到队尾
        判断队首元素是否已经不再窗口中
        若是形成了窗口, 则添加到结果数组中
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
                int left = i - k + 1;
                // 队首元素存活时间一定是最长的
                if (left > deque.getFirst()) {
                    deque.removeFirst();
                }
                // left > 0表示形成了窗口
                if (left >= 0) {
                    res[index++] = nums[deque.getFirst()];
                }
            }
            return res;
        }
    }
}
