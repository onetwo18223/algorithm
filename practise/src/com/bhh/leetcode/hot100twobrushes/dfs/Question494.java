package com.bhh.leetcode.hot100twobrushes.dfs;

/**
 * @author bhh
 * @description 目标和
 * @date Created in 2022-01-22 21:14
 * @modified By
 */
public class Question494 {
    class Solution {
        /*
        使用dfs
         */
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
            // TODO 这里出现问题, dfs并不是一定需要进行遍历, 遍历只是为了更好的获取一个开始点
            // 而这个开始点并不是一定的!!! 例如这道题, 开始点是确定好的了
            dfs(nums, 0, 0, target);
            return count;
        }

        private void dfs(int[] nums, int index, int sum, int target) {
            if (sum == target && index == nums.length){
                count++;
            }
            if (index >= nums.length) {
                return;
            }
            dfs(nums, index + 1, sum + nums[index], target);
            dfs(nums, index + 1, sum - nums[index], target);
        }
    }
}
