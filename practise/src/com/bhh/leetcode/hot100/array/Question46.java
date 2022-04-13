package com.bhh.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 全排列
 * @date Created in 2021-12-21 12:19
 * @modified By
 */
public class Question46 {
    class Solution {
        /*
        排列 : dfs
        需要visited
         */
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            List<Integer> list = new ArrayList<>();
            dfs(nums, visited, list, result);
            return result;
        }

        private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
            if (list.size() == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, result);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
