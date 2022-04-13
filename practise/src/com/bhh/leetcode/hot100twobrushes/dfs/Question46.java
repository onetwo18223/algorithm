package com.bhh.leetcode.hot100twobrushes.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 全排列
 * @date Created in 2022-01-21 12:26
 * @modified By
 */
public class Question46 {
    class Solution {
        /*
        排列问题 dfs
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            boolean[] visited = new boolean[len];
            for (int i = 0; i < len; i++) {
                visited[i] = true;
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                dfs(nums, visited, list, res);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
            return res;
        }

        private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, res);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
