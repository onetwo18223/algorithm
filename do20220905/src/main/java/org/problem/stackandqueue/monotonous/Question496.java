package org.problem.stackandqueue.monotonous;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大元素I
 * <p>
 * 实现：
 * 先使用hashMap获取nums2所在的索引位置
 * 应该先获取都nums2的元素，在
 * 对于nums2，应该使用单调递减栈生成每个最近最大的元素集合
 */
public class Question496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null
                    || nums1.length == 0 || nums2.length == 0)
                return new int[]{};
            // 创建map
            Map<Integer, Integer> map = new HashMap<>();

            // 创建单调递减栈
            Deque<Integer> stack = new ArrayDeque<>();
            int[] indexs = new int[nums2.length];
            for (int i = 0; i < nums2.length; i++) {
                while (!stack.isEmpty() && nums2[stack.getLast()] < nums2[i]) {
                    indexs[stack.getLast()] = nums2[i];
                    stack.removeLast();
                }
                stack.addLast(i);
                map.put(nums2[i], i);
            }

            // 处理循环后的栈元素
            while (!stack.isEmpty()) {
                indexs[stack.getLast()] = -1;
                stack.removeLast();
            }

            int[] res = new int[nums1.length];
            // 遍历nums1
            for (int i = 0; i < nums1.length; i++) {
                if (!map.containsKey(nums1[i])) {
                    res[i] = -1;
                    continue;
                }
                // map获取到改元素在nums2的索引位置
                res[i] = indexs[map.get(nums1[i])];
            }

            return res;
        }
    }
}
