package com.bhh.leetcode.hot100.stackandqueue;

import java.util.LinkedList;

/**
 * @author bhh
 * @description 滑动窗口最大值
 * @date Created in 2022-01-04 11:44
 * @modified By
 */
public class Question239 {
    class Solution {
        /*
        使用双端队列来完成, 队列中数据应该是单调递减的, 最大值应该存储在队首
        队列中存储值, 遍历nums, 若是队尾元素小于nums[i], 则将队列元素清空,
            添加nums[i]到队列
        获取left 指针 = right - k + 1
        若是队首元素(队首元素是最老的元素)小于 left 指针,
            则表示队首元素不再存在于滑动窗口中, 移除该元素
        存储滑动窗口最大值|窗口已经形成(left >= 0)
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            // 总共可以获取多少个窗口最大值
            int[] res = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();

            for (int right = 0; right < nums.length; right++) {
                // 若是队列队尾元素小于当前元素, 则删除(因为求得是最大值)
                // 队尾元素最小, 队首最大
                while (!queue.isEmpty() && nums[queue.getLast()] <= nums[right]) {
                    queue.removeLast();
                }
                // 添加当前元素到队列
                queue.add(right);
                // 左指针
                int left = right - k + 1;
                // 若是队首元素(最老的元素)小于左指针, 表示队首元素已经出了窗口, 需要被淘汰
                if (queue.getFirst() < left) {
                    queue.removeFirst();
                }
                // 判断是否形成了窗口
                if (left >= 0) {
                    res[left] = nums[queue.getFirst()];
                }
            }
            return res;
        }
    }
}
