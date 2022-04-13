package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 目标和
 * @date Created in 2022-01-29 12:17
 * @modified By
 */
public class Question494hot100 {
    class Solution {
        /*
        求方式 本应dp 但是dfs更简单一些
         */
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums, 0, 0, target);
            return count;
        }

        private void dfs(int[] nums, int index, int sum, int target) {
            if (index == nums.length && sum == target) {
                count++;
                return;
            }
            if (index >= nums.length) {
                return;
            }
            dfs(nums, index + 1, sum + nums[index], target);
            dfs(nums, index + 1, sum - nums[index], target);
        }
    }
}
