package com.bhh.leetcode.three;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 和为 K 的子数组
 * @date Created in 2022-01-28 20:21
 * @modified By
 */
public class Question560hot100 {
    class Solution {
        /*
        前缀和题目
         */
        public int subarraySum(int[] nums, int k) {
            int preSum = 0;
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                if (map.containsKey(preSum - k)) {
                    count += map.get(preSum - k);
                }
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }
}
