package com.bhh.leetcode.hot100.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 子集
 * @date Created in 2021-12-21 15:30
 * @modified By
 */
public class Question78 {
    class Solution {
        /*
        这道题要求求出所有组合方案 => DFS
        知道DFS, 但是第一时间没有下手的原因是我想不到 递归结束条件
        查看题解之后发现, for循环就是递归结束条件之一, 既是拆解了大问题, 又是结束条件

        因为设计到组合, 且和索引顺序有关, 所以参数有idnex
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(nums, 0, new ArrayList<Integer>(), result);
            return result;
        }

        private void dfs(int[] nums, int index,
                         ArrayList<Integer> list, List<List<Integer>> result) {
            result.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
