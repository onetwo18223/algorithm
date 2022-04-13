package com.bhh.leetcode.hot100twobrushes.array.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 和为 K 的子数组
 * @date Created in 2022-01-25 18:13
 * @modified By
 */
public class Question560 {
    class Solution {
        /*
        使用前缀和
        前缀和可以用来求连续数组元素的和为某一个定值

        生成前缀和, 使用HashMap充当容器, 以<前缀和, 次数>进行存储
        判断 值为 k 的前缀和是否存在,
            我们可以将这个条件转移为判断 当前前缀和 - k 的前缀和是否存在
        存在, 则num += map.get()即可
         */
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int preSum = 0;
            int count = 0;
            for (int num : nums) {
                preSum += num;
                if (map.containsKey(preSum - k)) {
                    count += map.get(preSum - k);
                }
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }
    }
}
