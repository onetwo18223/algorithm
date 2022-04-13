package com.bhh.leetcode.hot100twobrushes.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 子集
 * @date Created in 2022-01-21 19:40
 * @modified By
 */
public class Question78 {
    class Solution {
        /*
        全组合 dfs
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                dfs(nums, i, list, res);
                list.remove(list.size() - 1);
            }
            return res;
        }

        private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
            res.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
