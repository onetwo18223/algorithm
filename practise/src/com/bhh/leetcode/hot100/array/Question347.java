package com.bhh.leetcode.hot100.array;

import java.util.*;

/**
 * @author bhh
 * @description 前 K 个高频元素
 * @date Created in 2021-12-22 10:19
 * @modified By
 */
public class Question347 {
    class Solution {
        /*
        错误, 无法实现
        使用Hash表+栈实现
        topK问题
        使用栈/快排完成
         */
        public int[] topKFrequentError(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) {
                return new int[0];
            }
            int max = Integer.MIN_VALUE;
            Map<Integer, Integer> map = new HashMap<>();
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(nums[0]);
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                int count = map.get(num);
                if (count > max) {
                    max = count;
                    if (stack.isEmpty() || stack.peek() != num) {
                        stack.push(num);
                    }
                }
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = stack.pop();
            }
            return res;
        }

        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            // 添加次数到map中
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // 创建小顶堆, 判断依据是map.get(num)
            Queue<Integer> heap = new PriorityQueue<>(
                    (o1, o2) -> map.get(o1) - map.get(o2));
            for (int key : map.keySet()) {
                // heap数量不足k
                if (heap.size() < k) {
                    heap.add(key);
                }
                // 数量足了, 当出现次数频率大于堆顶元素频率时, 替换
                else if (map.get(heap.peek()) < map.get(key)) {
                    heap.remove();
                    heap.add(key);
                }
            }

            // 将heap数据转到数组
            int len = heap.size();
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = heap.remove();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        for (int i : new Question347().new Solution().topKFrequent(new int[]{
                1, 1, 1, 2, 2, 3
        }, 2)) {
            System.out.println(i);
        }
    }
}
