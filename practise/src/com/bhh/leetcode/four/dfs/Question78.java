package com.bhh.leetcode.four.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 子集
 * @date Created in 2022-03-03 20:55
 * @modified By
 */
public class Question78 {
    class Solution {
        /*
        比较简单的dfs入门题目
        全组合 dfs
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, 0, new ArrayList<>(), res);
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
