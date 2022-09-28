package org.problem.dfs.group;

import java.util.ArrayList;
import java.util.List;

/**
 * k数和（二）
 *
 * 实现：本题与Question135MD类似，但又不同，本地限制了俩个条件，target和位数
 *      且不需要去重和排序
 */
public class Question90MD {
    public class Solution {
        public List<List<Integer>> kSumII(int[] nums, int k, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            dfs(nums, 0, k, target, new ArrayList<>(), res);
            return res;
        }

        private void dfs(int[] nums, int index, int k, int target,
                         ArrayList<Integer> list, List<List<Integer>> res) {
            if (target == 0 && k == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (k == 0 || target < 0) return;
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, i + 1, k - 1, target - nums[i], list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
