package com.bhh.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author bhh
 * @description 数字组合
 * @date Created in 2021-12-10 22:09
 * @modified By
 */
public class Question135 {
    public class Solution {
        /*
        求方案, 使用DFS实现
        数字可以重复使用, 且输出需要有序
        去重 + 排序
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> sumsList = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return sumsList;
            }

            // 去重
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < candidates.length; i++) {
                set.add(candidates[i]);
            }
            int[] nums = new int[set.size()];
            int i = 0;
            for (Integer num : set) {
                nums[i++] = num;
            }
            // 排序
            Arrays.sort(nums);

            dfs(nums, 0, target, new ArrayList<>(), sumsList);
            return sumsList;
        }

        private void dfs(int[] a, int index, int target, ArrayList<Integer> sums, List<List<Integer>> sumsList) {
            // 递归满足条件退出
            if (target == 0) {
                sumsList.add(new ArrayList<>(sums));
                return;
            }
            // 递归退出条件
            if (target < 0) {
                return;
            }
            for (int i = index; i < a.length; i++) {
                sums.add(a[i]);
                dfs(a, i, target - a[i], sums, sumsList);
                sums.remove(sums.size() - 1);
            }
        }
    }
}
