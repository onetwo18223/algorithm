package com.bhh.leetcode.hot100twobrushes.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 组合总和
 * @date Created in 2022-01-21 16:17
 * @modified By
 */
public class Question39 {
    class Solution {
        /*
        求组合, 使用dfs
         */
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, i, list, target - nums[i], res);
                list.remove(list.size() - 1);
            }
            return res;
        }

        private void dfs(int[] nums, int index, List<Integer> list, int target, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            if (target < 0) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, i, list, target - nums[i], res);
                list.remove(list.size() - 1);
            }
        }
    }
}
