package com.bhh.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description k数和（二）
 * @date Created in 2021-12-10 22:09
 * @modified By
 */
public class Question90 {
    public class Solution {
        /*
        求方案, 使用DFS实现
        数字不可以重复使用
         */
        public List<List<Integer>> kSumII(int[] A, int k, int target) {
            List<List<Integer>> sumsList = new ArrayList<>();
            if (A == null || A.length == 0) {
                return sumsList;
            }
            dfs(A, 0, k, target, new ArrayList<>(), sumsList);
            return sumsList;
        }

        private void dfs(int[] a, int index, int k, int target, ArrayList<Integer> sums, List<List<Integer>> sumsList) {
            // 递归满足条件退出
            if (k == 0 && target == 0) {
                sumsList.add(new ArrayList<>(sums));
                return;
            }
            // 递归退出条件
            if (k == 0 || target <= 0) {
                return;
            }
            for (int i = index; i < a.length; i++) {
                sums.add(a[i]);
                dfs(a, i + 1, k - 1, target - a[i], sums, sumsList);
                sums.remove(sums.size() - 1);
            }
        }
    }
}
