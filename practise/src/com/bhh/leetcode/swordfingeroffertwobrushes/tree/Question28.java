package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 对称的二叉树
 * @date Created in 2022-01-14 17:01
 * @modified By
 */
public class Question28 {
    class Solution {
        /*
        查询 先序
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return dfs(root, root);
        }

        private boolean dfs(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            return dfs(node1.left, node2.right)
                    && dfs(node1.right, node2.left);

        }
    }
}
