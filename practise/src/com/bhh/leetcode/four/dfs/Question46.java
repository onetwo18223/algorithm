package com.bhh.leetcode.four.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 全排列
 * @date Created in 2022-03-03 20:56
 * @modified By
 */
public class Question46 {
    class Solution {
        /*
         * dfs排列入门题目, 求全排列组合
         * 与组合题目不同点在于需要使用到剪枝
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            dfs(nums, new ArrayList<Integer>(), visited, res);
            return res;
        }

        private void dfs(int[] nums, ArrayList<Integer> list,
                         boolean[] visited,
                         List<List<Integer>> res) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    dfs(nums, list, visited, res);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
