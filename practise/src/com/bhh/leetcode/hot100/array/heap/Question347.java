package com.bhh.leetcode.hot100.array.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author bhh
 * @description 前 K 个高频元素
 * @date Created in 2022-01-06 15:33
 * @modified By
 */
public class Question347 {
    class Solution {
        /*
        使用堆排序
         */
        public int[] topKFrequent(int[] nums, int k) {
            // 先将nums存入Map中
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // 初始化最小堆
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (o1, o2) -> map.get(o1) - map.get(o2));
            for (Integer key : map.keySet()) {
                // 堆中元素小于k
                if (pq.size() < k) {
                    pq.add(key);
                }
                // 堆中元素等于k
                // 判断出现的频率, 频率大的替换频率小的
                // 因为最小堆, 所以堆顶元素是频率小的
                else if (map.get(key) > map.get(pq.peek())) {
                    pq.remove();
                    pq.add(key);
                }
            }
            int[] res = new int[pq.size()];
            int i = 0;
            while (!pq.isEmpty()) {
                res[i++] = pq.remove();
            }
            return res;
        }
    }
}
