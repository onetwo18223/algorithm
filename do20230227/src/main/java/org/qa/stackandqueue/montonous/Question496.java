package org.qa.stackandqueue.montonous;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 下一个更大元素 I
 * https://leetcode.cn/problems/next-greater-element-i/
 * 实现：
 * 使用单调队列实现，将key值存入队列，遍历，当出现大于nums[key]的元素时，
 *      将这个值存储在(value->key, 较大值value)map中
 * @Author Bhh
 * @Date 2023-03-31 14:35
 * @Version 1.0
 */
public class Question496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            if (null == nums1 || null == nums2 ||
                    nums1.length == 0 || nums2.length == 0) return new int[]{};
            Deque<Integer> stack = new ArrayDeque<Integer>();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums2.length; i++) {
                while(!stack.isEmpty() && nums2[stack.getFirst()] < nums2[i]) {
                    map.put(nums2[stack.removeFirst()], nums2[i]);
                }
                stack.addFirst(i);
            }

            while(!stack.isEmpty()) {
                map.put(nums2[stack.removeFirst()], -1);
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}
