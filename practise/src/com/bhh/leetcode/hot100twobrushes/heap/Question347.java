package com.bhh.leetcode.hot100twobrushes.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author bhh
 * @description 前 K 个高频元素
 * @date Created in 2022-01-20 21:43
 * @modified By
 */
public class Question347 {
    /*
    使用Hash + 堆
    这道题为什么使用最小堆?
        使用最大最小堆看的是堆顶元素,
        假设元素已满, 这种情况如果需要删除元素, 我们只能删除堆顶元素
        这时候我们就需要对比堆顶元素和想要添加的元素, 因为我们只能删除堆顶元素
     */
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
