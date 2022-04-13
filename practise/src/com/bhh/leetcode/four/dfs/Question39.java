package com.bhh.leetcode.four.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 组合总和
 * @date Created in 2022-03-03 21:42
 * @modified By
 */
public class Question39 {
    class Solution {
        /*
        dfs组合, 漏元素组合方式
         */
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, 0, target, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[] nums, int index, int target,
                         List<Integer> list,
                         List<List<Integer>> res) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, i, target - nums[i], list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
