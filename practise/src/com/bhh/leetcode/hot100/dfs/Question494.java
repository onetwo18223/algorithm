package com.bhh.leetcode.hot100.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bhh
 * @description 目标和
 * @date Created in 2022-01-02 15:29
 * @modified By
 */
public class Question494 {
    class Solution {
        /*
        求方式/考虑DP/背包型DP(不会)
        因为是各种组合的方式, 所以退而求次使用DFS
        DFS是递归, 但我们可以实现记忆化搜索
         */
        Map<String, Integer> map = new HashMap<>();

        public int findTargetSumWays(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            return dfs(nums, target, 0, 0);
        }

        private int dfs(int[] nums, int target, int sum, int index) {
            int len = nums.length;
            // 为什么需要index == len?
            // 因为dfs定义是判断加nums[index]之前是否符合条件
            // 所以会错开一位
            if (len == index && target == sum) {
                return 1;
            }
            if (index >= len) {
                return 0;
            }
            int add = dfs(nums, target, sum + nums[index], index + 1);
            int red = dfs(nums, target, sum - nums[index], index + 1);
            return add + red;
        }

        private int dfsWithRem(int[] nums, int target, int sum, int index) {
            String key = sum + "-" + index;
            int len = nums.length;
            // 为什么需要index == len?
            // 因为dfs定义是判断加nums[index]之前是否符合条件
            // 所以会错开一位
            if (len == index && target == sum) {
                map.put(key, 1);
                return 1;
            }
            if (index >= len) {
                map.put(key, 0);
                return 0;
            }
            if (map.containsKey(key)) {
                return map.get(key);
            }
            int add = dfs(nums, target, sum + nums[index], index + 1);
            int red = dfs(nums, target, sum - nums[index], index + 1);
            map.put(key, add + red);
            return add + red;
        }
    }
}
