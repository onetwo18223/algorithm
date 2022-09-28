package org.problem.dfs.arrangement;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * 实现：使用dfs遍历进行排列组和
 * 感悟：从这道题已经可以看出BFS和DFS有很大的类似点
 */
public class Question46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            int len = nums.length;
            int[] visited = new int[len];
            dfs(nums, visited, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[] nums, int[] visited, ArrayList<Integer> list, List<List<Integer>> res) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1) continue;
                list.add(nums[i]);
                visited[i] = 1;
                dfs(nums, visited, list, res);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
