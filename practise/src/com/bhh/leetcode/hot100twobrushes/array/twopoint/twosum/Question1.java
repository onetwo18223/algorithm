package com.bhh.leetcode.hot100twobrushes.array.twopoint.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 两数之和
 * @date Created in 2022-01-21 9:37
 * @modified By
 */
public class Question1 {
    class Solution {
        /*
        错误, 因为是返回下标, 所以无法排序, 因此这种方法不适用
        双指针, left = 0, right = nums.length - 1
        sum > target, right--;
        sum < target, left++;
         */
        public int[] twoSumErrorForThis(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;
            // 结束left == right
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return new int[]{left, right};
                }
            }
            return new int[]{};
        }

        /*
        如若需要返回下标则需要使用HashMap
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}
