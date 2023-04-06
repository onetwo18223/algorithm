package org.qa.twopointer.reversepointer.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 两数之和
 * https://leetcode.cn/problems/two-sum/?favorite=2cktkvj
 * @Author bhh
 * @Date 2023-02-27 10:04
 * @Version 1.0
 */
public class Question1 {
    {
        /* 实现：
        如果返回值，那么使用双指针
        如果返回索引，那么使用HashMap
         */
    }

    // 返回值-双指针
    class SolutionGoodMethod1 {
        public int[] twoSum(int[] nums, int target) {

            if (null == nums || nums.length == 0) return new int[]{0, 0};
            Arrays.sort(nums);

            int left = 0, right = nums.length - 1, sum = 0;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{nums[left], nums[right]};
                }
                if (sum > target) {
                    right--;
                    continue;
                }
                left++;
            }

            return new int[]{0, 0};
        }
    }

    // 返回索引-HashMap
    // TODO：为什么使用了Map还用到了双指针？
    class SolutionBad {
        public int[] twoSum(int[] nums, int target) {

            if (null == nums || nums.length == 0) return new int[]{0, 0};

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(map.get(i), i);
            }
            Arrays.sort(nums);

            int left = 0, right = nums.length - 1, sum = 0;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{map.get(nums[left]), map.get(nums[right])};
                }
                if (sum > target) {
                    right--;
                    continue;
                }
                left++;
            }

            return new int[]{0, 0};
        }
    }

    // 返回索引-HashMap
    class Solution_GoodMethod2 {
        public int[] twoSum(int[] nums, int target) {

            if (null == nums || nums.length == 0) return new int[]{0, 0};

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int findValue = target - nums[i];
                if (map.containsKey(findValue)) {
                    return new int[]{i, map.get(findValue)};
                }
                map.put(nums[i], i);
            }

            return new int[]{0, 0};
        }
    }
}
