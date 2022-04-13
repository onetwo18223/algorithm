package com.bhh.leetcode.four.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bhh
 * @description 和为 K 的子数组
 * @date Created in 2022-03-04 22:34
 * @modified By
 */
public class Question560 {
    class Solution {
        /*
        前缀和题目, 存储前缀和到set
         */
        public int subarraySumError(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            set.add(0);
            int count = 0;
            int pre = 0;
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (set.contains(pre - k)) {
                    count++;
                }
                set.add(pre);
            }
            return count;
        }

        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int pre = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (map.containsKey(pre - k)) {
                    count += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
}
