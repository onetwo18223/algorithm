package com.bhh.leetcode.hot100.tree;

/**
 * @author bhh
 * @description 二叉树的最近公共祖先
 * @date Created in 2021-12-26 12:49
 * @modified By
 */
public class Question236 {
    class Solution {
        /*
        查询节点, DFS, 后序遍历
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
            if (leftNode != null && rightNode != null) {
                return root;
            }
            if (leftNode != null) {
                return leftNode;
            }
            if (rightNode != null) {
                return rightNode;
            }
            return null;
        }
    }
}
