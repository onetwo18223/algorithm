package com.bhh.leetcode.four.dfs;

/**
 * @author bhh
 * @description 目标和
 * @date Created in 2022-03-04 20:00
 * @modified By
 */
public class Question494 {
    class Solution {
        /*
        使用dfs
         */
        int count = 0;
        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums, 0, target);
            return count;
        }

        private void dfs(int[] nums, int index, int target) {
            if (index == nums.length && target == 0) {
                count++;
                return;
            }
            if (index >= nums.length) {
                return;
            }
            dfs(nums, index + 1, target - nums[index]);
            dfs(nums, index + 1, target + nums[index]);
        }
    }
}
