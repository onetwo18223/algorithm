package com.bhh.leetcode.hot100.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 组合总和
 * @date Created in 2021-12-21 11:40
 * @modified By
 */
public class Question39 {
    class Solution {
        /*
        排列组合 : DFS
        可以重复使用
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> resultList = new ArrayList<>();
//            if (candidates == null || candidates.length == 0){
//                return resultList;
//            }
            List<Integer> list = new ArrayList<>();
            dfs(candidates, 0, target, list, resultList);
            return resultList;
        }

        private void dfs(int[] candidates, int index, int target,
                         List<Integer> list, List<List<Integer>> resultList) {
            if (target == 0) {
                resultList.add(new ArrayList<>(list));
                return;
            }
            if (target < 0){
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                dfs(candidates, i, target - candidates[i], list, resultList);
                list.remove(list.size() - 1);
            }
        }
    }
}
