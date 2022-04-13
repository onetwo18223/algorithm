package com.bhh.leetcode.three;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author bhh
 * @description 前 K 个高频元素
 * @date Created in 2022-01-29 11:56
 * @modified By
 */
public class Question347hot100 {
    class Solution {
        /*
        使用HashMap + PriorityQueue
         */
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            // 小顶堆
            Queue<Integer> heap = new PriorityQueue<>(
                    (o1, o2) -> (map.get(o1) - map.get(o2)));
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Integer num : map.keySet()) {
                // 直接添加
                if (heap.isEmpty() || heap.size() < k) {
                    heap.add(num);
                }
                // 元素数量超过k, 判断堆顶元素和该元素出现频率
                else if (map.get(heap.peek()) < map.get(num)) {
                    heap.poll();
                    heap.add(num);
                }
            }
            // 输出堆到数组
            int size = heap.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = heap.poll();
            }
            return res;
        }
    }
}
