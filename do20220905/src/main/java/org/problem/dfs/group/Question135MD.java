package org.problem.dfs.group;

import java.util.*;

/**
 * 数字组合
 *
 * 实现：需要注意去重
 */
public class Question135MD {
    public class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return res;

            // 去重 + 排序
            HashSet<Integer> set = new HashSet();
            for (int i = 0; i < candidates.length; i++) set.add(candidates[i]);
            int[] nums = new int[set.size()];
            int i = 0;
            for (Integer num : set) nums[i++] = num;
            Arrays.sort(nums);

            dfs(nums, target, 0, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[] nums, int target, int index,
                         ArrayList<Integer> list, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (target < 0) return;
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, target - nums[i], i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
