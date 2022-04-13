package com.bhh.leetcode.three;

/**
 * @author bhh
 * @description 对称二叉树
 * @date Created in 2022-01-30 10:59
 * @modified By
 */
public class Question101hot100 {
    class Solution {
        // 多节点 先序 查询
        public boolean isSymmetric(TreeNode root) {
            return dfs(root, root);
        }

        private boolean dfs(TreeNode root, TreeNode root1) {
            if (root == null && root1 == null) {
                return true;
            }
            if (root == null || root1 == null) {
                return false;
            }
            return root.val == root1.val && dfs(root.left, root1.right) && dfs(root.right, root1.left);
        }
    }
}
