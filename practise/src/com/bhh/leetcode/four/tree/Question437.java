package com.bhh.leetcode.four.tree;

/**
 * @author bhh
 * @description 路径总和 III
 * @date Created in 2022-03-04 17:06
 * @modified By
 */
public class Question437 {
    class Solution {
        /*
        dfs实现
        查询, 先序遍历
        本题需要先遍历树节点, 从树节点开始寻找起始点, 所以需要dfs嵌套dfs
         */
        int res = 0;
        int target;

        public int pathSum(TreeNode root, int targetSum) {
            this.target = targetSum;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root, target);
            dfs(root.left);
            dfs(root.right);
        }

        private void dfs(TreeNode root, int target) {
            if (root == null) {
                return;
            }
            target = target - root.val;
            if (target == 0) {
                res++;
            }
            dfs(root.left, target);
            dfs(root.right, target);
        }
    }
}
