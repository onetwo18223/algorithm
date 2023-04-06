package org.qa.dfs.arrangement;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 全排列
 * https://leetcode.cn/problems/permutations/
 * @Author Bhh
 * @Date 2023-04-06 15:11
 * @Version 1.0
 */
public class Question46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (null == nums || nums.length == 0) return res;
            int len = nums.length;
            int[] visited = new int[len];
            this.dfs(nums, visited, new ArrayList<Integer>(), res);
            return res;
        }

        private void dfs(int[] nums, int[] visited, ArrayList<Integer> list, List<List<Integer>> res) {
            // 递归结束条件
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            /* TODO：全排列
                  对于本次使用的元素需要设置visited[]为1，且将该元素添加到集合，
                  递归传递添加了本元素的数据（visited， list等）
                  在递归结束后需要进行还原，保证不影响之后的各种情况遍历
             */
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
