package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhh
 * @description 二叉树中和为某一值的路径
 * @date Created in 2022-01-14 12:37
 * @modified By
 */
public class Question34 {
    class Solution {
        /*
        就是dfs
        查询 先序遍历
         */
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            dfs(root, target, new ArrayList<>(), res);
            return res;
        }

        private void dfs(TreeNode root, int target, ArrayList<Object> list, List<List<Integer>> res) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            target -= root.val;
            if (target == 0 && root.left == null && root.right == null) {
                res.add(new ArrayList(list));
            }
            dfs(root.left, target, list, res);
            dfs(root.right, target, list, res);
            list.remove(list.size() - 1);
        }
    }
}
