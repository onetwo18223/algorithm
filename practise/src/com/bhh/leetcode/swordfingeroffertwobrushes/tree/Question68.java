package com.bhh.leetcode.swordfingeroffertwobrushes.tree;

/**
 * @author bhh
 * @description 二叉树的最近公共祖先
 * @date Created in 2022-01-14 13:09
 * @modified By
 */
public class Question68 {
    class Solution {
        /*
        求公共祖先, 查询, 先序
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) {
                return null;
            }
            if (root == p || root == q) {
                return root;
            }
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
            if(leftNode != null && rightNode != null) {
                return root;
            }
            if (leftNode != null) {
                return leftNode;
            }
            return rightNode;
        }
    }
}
