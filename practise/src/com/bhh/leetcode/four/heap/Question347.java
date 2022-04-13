package com.bhh.leetcode.four.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author bhh
 * @description 前 K 个高频元素
 * @date Created in 2022-03-04 8:16
 * @modified By
 */
public class Question347 {
    class Solution {
        /*
        借助优先队列完成
        需要使用到小顶堆
         */
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            Queue<Integer> heap = new PriorityQueue<Integer>(
                    (o1, o2) -> map.get(o1) - map.get(o2));
            for (Integer num : map.keySet()) {
                if (heap.size() >= k) {
                    if (map.get(heap.peek()) < map.get(num)) {
                        heap.poll();
                        heap.add(num);
                    }
                } else {
                    heap.add(num);
                }
            }
            int[] res = new int[heap.size()];
            for (int i = heap.size() - 1; i >= 0; i--) {
                res[i] = heap.poll();
            }
            return res;
        }
    }
}
